package com.coretheorylife.common.pay.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ServiceException;
import com.coretheorylife.common.pay.config.PayConfig;
import com.coretheorylife.common.pay.config.PayUtils;
import com.coretheorylife.common.pay.service.PayService;
import com.coretheorylife.common.utils.SnowflakeIdGenerator;
import com.coretheorylife.config.IdGeneratorConfig;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountLogService;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.egzosn.pay.ali.api.AliPayService;
import com.egzosn.pay.ali.bean.AliTransactionType;
import com.egzosn.pay.common.api.BasePayConfigStorage;
import com.egzosn.pay.common.bean.PayOrder;
import com.egzosn.pay.wx.api.WxPayService;
import com.egzosn.pay.wx.bean.WxTransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Connor
 * 移动支付实现类
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    @Autowired
    private PayUtils payUtils;

    @Autowired
    private TPurchaserAccountLogService logService;

    @Autowired
    private TOrderService tOrderService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Object> unifiedOrder(String payType, Long purchaserId, Long orderId) {
        TOrder tOrder = tOrderService.queryObject(orderId);
        if (tOrder == null) {
            throw new InvalidParameterException("订单找不到了~请重新下单");
        }
        BasePayConfigStorage payConfigStorage = payUtils.getPayConfigStorage(payType);
        if (payConfigStorage == null) {
            throw new ServiceException("生成预支付订单失败，请联系管理员");
        }
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(IdGeneratorConfig.workerId, IdGeneratorConfig.datacenterId);
        Map<String, Object> data = new HashMap<>();
        long orderNo = snowflakeIdGenerator.nextId();
        data.put("orderNo", orderNo);
        String subject = "核心理论-在线订单";
        String body = "订单支付";
        String prepayId = "";
        TPurchaserAccountLog tPurchaserAccountLog = new TPurchaserAccountLog();
        if (payType.equals(PayConfig.PAY_TYPE_ALI_PAY)) {
            AliPayService aliPayService = new AliPayService(payConfigStorage, payUtils.getAliHttpConfigStorage());
            PayOrder order = new PayOrder(subject, body, tOrder.getPayPrice(), orderNo + "");
            order.setTransactionType(AliTransactionType.APP);
            Map<String, Object> map = aliPayService.orderInfo(order);
            data.put("orderInfo", map);
            tPurchaserAccountLog.setPayType(ExtTPurchaserAccountLog.PAY_TYPE_ALI);
        } else if (payType.equals(PayConfig.PAY_TYPE_WX_PAY)) {
            WxPayService wxPayService = new WxPayService(payConfigStorage, payUtils.getWxHttpConfigStorage());
            PayOrder order = new PayOrder(subject, body, tOrder.getPayPrice(), orderNo + "");
            //App支付
            order.setTransactionType(WxTransactionType.NATIVE);
            Map<String, Object> map = wxPayService.orderInfo(order);
            prepayId = map.get("prepayid") + "";
            data.put("orderInfo", map);
            tPurchaserAccountLog.setPayType(ExtTPurchaserAccountLog.PAY_TYPE_WX);
        } else {
            throw new InvalidParameterException("目前只支持支付宝和微信支付");
        }
        data.put("prepayId", prepayId);
        tPurchaserAccountLog.setPurchaserId(purchaserId);
        tPurchaserAccountLog.setOrderId(orderId);
        tPurchaserAccountLog.setStatus(ExtTPurchaserAccountLog.STATUS_PENDING_REVIEW);
        tPurchaserAccountLog.setType(ExtTPurchaserAccountLog.TYPE_CONSUMPTION);
        tPurchaserAccountLog.setAmount(tOrder.getPayPrice());
        tPurchaserAccountLog.setPrepayId(prepayId);
        tPurchaserAccountLog.setOrderNo(orderNo + "");
        logService.save(tPurchaserAccountLog);
        return data;
    }

    @Override
    public int shopRefund(Long orderId, BigDecimal amount) {
        TPurchaserAccountLog tPurchaserAccountLog = logService.queryOrderPayByOrderId(orderId);
        if (tPurchaserAccountLog == null) {
            throw new InvalidParameterException("没有找到对应的支付记录，请联系客服");
        }
        if (tPurchaserAccountLog.getPayType().equals(ExtTPurchaserAccountLog.PAY_TYPE_ALI)) {
            // ALI
            BasePayConfigStorage payConfigStorage = payUtils.getPayConfigStorage(PayConfig.PAY_TYPE_ALI_PAY);
            AliPayService aliPayService = new AliPayService(payConfigStorage, payUtils.getAliHttpConfigStorage());
            aliPayService.refundquery(tPurchaserAccountLog.getPrepayId(), tPurchaserAccountLog.getOrderNo());


        } else if(tPurchaserAccountLog.getPayType().equals(ExtTPurchaserAccountLog.PAY_TYPE_WX)) {
            // WX
        } else {

        }
        return 0;
    }
}
