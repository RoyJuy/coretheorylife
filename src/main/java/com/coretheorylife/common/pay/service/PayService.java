package com.coretheorylife.common.pay.service;

import java.math.BigDecimal;
import java.util.Map;

public interface PayService {

    /**
     * 在线支付统一下单
     *
     * @param payType
     * @param purchaserId
     * @param orderId
     * @return
     */
    Map<String, Object> unifiedOrder(String payType, Long purchaserId, Long orderId);

    /**
     * 退款 商家责任
     * @param orderId
     * @param amount
     * @return
     */
    int shopRefund(Long orderId, BigDecimal amount);
}
