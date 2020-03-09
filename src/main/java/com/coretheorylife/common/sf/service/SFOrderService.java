package com.coretheorylife.common.sf.service;

import com.coretheorylife.common.sf.entity.CreateOrderQueryResult;
import com.coretheorylife.common.sf.entity.CreateOrderResult;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.TShop;

import java.math.BigDecimal;

public interface SFOrderService {

    /**
     * @param user_address 用户详细地址
     * @param weight       物品重量（单位：克）
     * @param is_appoint   是否是预约单 0：非预约单；1：预约单
     * @param expect_time  期望送达时间,预约单需必传 秒级时间戳
     * @param shop_name    店铺姓名
     * @param shop_phone   店铺电话
     * @param shop_address 店铺地址
     * @return
     */
    CreateOrderQueryResult createOrderQuery(String user_address, BigDecimal userLong, BigDecimal userLat, Integer weight, Integer is_appoint, Integer expect_time, String shop_name, String shop_phone, String shop_address, BigDecimal shopLong, BigDecimal shopLat);

    /**
     * @return
     */
    CreateOrderResult createOrder(TOrder tOrder, TShop tShop);
}
