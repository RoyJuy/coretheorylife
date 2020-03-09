package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TOrderLog;

public class ExtTOrderLog extends TOrderLog {

    /**
     * 用户下单
     */
    public static final int CREATE_ORDER = 1;

    /**
     * 用户催单
     */
    public static final int URGE_ORDER = 2;

    /**
     * 用户取消订单
     */
    public static final int CANCEL_ORDER = 3;

    /**
     * 商家接单
     */
    public static final int RECEIVE_ORDER = 4;

    /**
     * 商家拒绝接单
     */
    public static final int REJECT_ORDER = 5;

    /**
     * 超时未支付取消
     */
    public static final int PAY_TIME_OUT = 6;

    /**
     * 超时未接单取消
     */
    public static final int PAY_TIME_OUT_AFTER_PAY = 7;

    /**
     * 顺丰配送回调
     */
    public static final int ORDER_STATUS_CHANGE = 8;

}
