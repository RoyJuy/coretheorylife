package com.coretheorylife.common.sf.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.sf.entity.CreateOrderQueryResult;
import com.coretheorylife.common.sf.entity.CreateOrderResult;
import com.coretheorylife.common.sf.service.SFOrderService;
import com.coretheorylife.common.sf.utils.SFSignUtils;
import com.coretheorylife.common.utils.OkHttpUtils;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrderLine;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Connor
 * 顺丰业务实现
 */
@Service("sFOrderServiceImpl")
public class SFOrderServiceImpl implements SFOrderService {

    public static final String CREATE_ORDER_QUERY = "https://commit-openic.sf-express.com/open/api/external/precreateorder?sign=";

    public static final String CREATE_ORDER = "https://commit-openic.sf-express.com/open/api/external/createorder?sign=";

    @Autowired
    private TOrderService tOrderService;

    @Override
    public CreateOrderQueryResult createOrderQuery(String user_address, BigDecimal userLong, BigDecimal userLat, Integer weight, Integer is_appoint, Integer expect_time, String shop_name, String shop_phone, String shop_address, BigDecimal shopLong, BigDecimal shopLat) {
        Map<String, Object> map = new HashMap<>();
        map.put("dev_id", SFSignUtils.APP_ID);
        map.put("shop_id", SFSignUtils.SHOP_ID);
        // 1快餐;2送药;3百货;4脏衣服收;5干净衣服派;6生鲜;7保单;8饮品;9现场勘查;10快递;12文件证照;13蛋糕;14鲜花;15电子数码;16服装鞋帽;17汽车配件;18珠宝;20披萨;21中餐;99其他
        map.put("product_type", 21);
        // 用户支付方式：1、已支付 0、货到付款
        map.put("pay_type", 1);
        // 是否保价，0：非保价；1：保价
        map.put("is_insured", 0);
        // 1：从门店取件送至用户；
        // 2：从用户取件送至门店
        map.put("rider_pick_method", 1);
        // 1:商品总价格，2:配送距离，4:物品重量，8:起送时间，16:期望送达时间，32:支付费用，64:实际支持金额，128:优惠卷总金额，256:结算方式
        // 例如全部返回为填入511
        map.put("return_flag", 511);
        map.put("push_time", new Date().getTime() / 1000);
        map.put("user_address", user_address);
        map.put("weight", weight);
        map.put("is_appoint", is_appoint);
        map.put("expect_time", expect_time);
        map.put("user_lng", userLong);
        map.put("user_lat", userLat);
        // 坐标类型，1：百度坐标，2：高德坐标
        map.put("lbs_type", 2);
        Map<String, Object> shopMap = new HashMap<>();
        shopMap.put("shop_name", shop_name);
        shopMap.put("shop_phone", shop_phone);
        shopMap.put("shop_address", shop_address);
        shopMap.put("shop_lng", shopLong);
        shopMap.put("shop_lat", shopLat);
        map.put("shop", shopMap);

        String paran = new Gson().toJson(map);
        String sign = SFSignUtils.getSign(paran);
        String url = CREATE_ORDER_QUERY + sign;
        return new Gson().fromJson(OkHttpUtils.putSF(map, url), CreateOrderQueryResult.class);
    }

    @Override
    public CreateOrderResult createOrder(TOrder tOrder, TShop tShop) {
        Map<String, Object> map = new HashMap<>();
        map.put("dev_id", SFSignUtils.APP_ID);
        map.put("shop_id", SFSignUtils.SHOP_ID);
        map.put("shop_order_id", tOrder.getOrderNo());
        map.put("order_source", "核心理论");
        map.put("order_sequence", tOrder.getOrderCount());
        map.put("order_time", tOrder.getOrderTime().getTime() / 1000);
        // 1快餐;2送药;3百货;4脏衣服收;5干净衣服派;6生鲜;7保单;8饮品;9现场勘查;10快递;12文件证照;13蛋糕;14鲜花;15电子数码;16服装鞋帽;17汽车配件;18珠宝;20披萨;21中餐;99其他
        map.put("product_type", 21);
        // 用户支付方式：1、已支付 0、货到付款
        map.put("pay_type", 1);
        // 是否保价，0：非保价；1：保价
        map.put("is_insured", 0);
        // 1：从门店取件送至用户；
        // 2：从用户取件送至门店
        map.put("rider_pick_method", 1);
        // 1:商品总价格，2:配送距离，4:物品重量，8:起送时间，16:期望送达时间，32:支付费用，64:实际支持金额，128:优惠卷总金额，256:结算方式
        // 例如全部返回为填入511
        map.put("return_flag", 511);
        map.put("push_time", new Date().getTime() / 1000);
        map.put("weight", tOrder.getWeight());
        if (tOrder.getShipType() == ExtTOrder.SHIP_TYPE_NOW) {
            map.put("is_appoint", 0);
        } else {
            map.put("is_appoint", 1);
            map.put("expect_time", tOrder.getShipTime().getTime() / 1000);
        }
        map.put("version", 17);
        // 坐标类型，1：百度坐标，2：高德坐标
        map.put("lbs_type", 2);
        Map<String, Object> shopMap = new HashMap<>();
        shopMap.put("shop_name", tShop.getName());
        shopMap.put("shop_phone", tShop.getOrderPhone());
        shopMap.put("shop_address", tShop.getAddress() + tShop.getAddressDetailes());
        shopMap.put("shop_lng", tShop.getLongitude());
        shopMap.put("shop_lat", tShop.getLatitude());
        map.put("shop", shopMap);

        Map<String, Object> receiveMap = new HashMap<>();
        receiveMap.put("user_name", tOrder.getReceiverName());
        receiveMap.put("user_phone", tOrder.getReceiverMobile());
        receiveMap.put("user_address", tOrder.getShipPrefix() + tOrder.getShipSuffix());
        receiveMap.put("user_lng", tOrder.getShipLongitude());
        receiveMap.put("user_lat", tOrder.getShipLatitude());
        map.put("receive", receiveMap);
        Map<String, Object> orderQueryMap = new HashMap<>();
        orderQueryMap.put("orderId", tOrder.getId());
        List<ExtTOrder> list = tOrderService.queryListByShopIdOrUserId(orderQueryMap);
        if (list.isEmpty()) {
            throw new InvalidParameterException("配送服务开小差了~");
        }
        ExtTOrder order = list.get(0);
        List<Map<String, Object>> productDetailList = new ArrayList<>();
        Map<String, Object> orderDetailMap = new HashMap<>();
        Map<String, Object> productDetailMap;
        BigDecimal total_price = BigDecimal.ZERO;
        int weight_gram = 0;
        int product_num = 0;
        int product_type_num = 0;
        for (ExtTOrderLine orderLine : order.getOrderLines()) {
            productDetailList = new ArrayList<>();
            productDetailMap = new HashMap<>();
            productDetailMap.put("product_name", orderLine.getGoods().getName());
            productDetailMap.put("product_num", orderLine.getNumber());
            productDetailList.add(productDetailMap);
            total_price = total_price.add(orderLine.getGoods().getPrice().multiply(new BigDecimal(orderLine.getNumber() * 100)));
            weight_gram += orderLine.getGoods().getWeight();
            product_num += orderLine.getNumber();
            product_type_num++;
        }
        orderDetailMap.put("total_price", total_price);
        orderDetailMap.put("product_type", 1);
        orderDetailMap.put("weight_gram", weight_gram);
        orderDetailMap.put("product_num", product_num);
        orderDetailMap.put("product_type_num", product_type_num);
        orderDetailMap.put("product_detail", productDetailList);
        map.put("order_detail", orderDetailMap);
        String values = new Gson().toJson(map);
        String sign = SFSignUtils.getSign(values);
        String url = CREATE_ORDER + sign;
        return new Gson().fromJson(OkHttpUtils.putSF(map, url), CreateOrderResult.class);
    }
}
