package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.TOrderLog;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ExtTOrder extends TOrder implements Serializable {

    //配送状态 1-等待接单 2-商家已接单 3-已分配骑手 4-骑手已到店 5-配送中 6-已送达 7-异常 8-已取消

    public static final int SHIP_STATUS_WAIT_ORDER = 1;

    public static final int SHIP_STATUS_IN_ORDER = 2;

    public static final int SHIP_STATUS_ASSIGNED_DELIVERY_PERSON = 3;

    public static final int SHIP_STATUS_IN_SHOP = 4;

    public static final int SHIP_STATUS_IN_SEND = 5;

    public static final int SHIP_STATUS_SEND = 6;

    public static final int SHIP_STATUS_EXCEPTION = 7;

    public static final int SHIP_STATUS_CANCEL = 8;

    //订单状态 1-待付款 2-付款成功 3-进行中 4-制作完成 5-已完成 6-用户已取消 7-商家已拒绝 8-申请退款中 9-已退款 10-退款已拒绝 11-支付后取消 12-配送原因取消 等待重新发起配送
    public static final int STATUS_WAIT_PAY = 1;

    public static final int STATUS_PAY_SUCCESS = 2;

    public static final int STATUS_IN_ORDER = 3;

    public static final int STATUS_MAKE_DONE = 4;

    public static final int STATUS_SUCCESS = 5;

    public static final int STATUS_PURCHASER_CANCEL = 6;

    public static final int STATUS_SHOP_CANCEL = 7;

    public static final int STATUS_IN_REFUND = 8;

    public static final int STATUS_REFUND_SUCCESS = 9;

    public static final int STATUS_REFUND_FAILED = 10;

    public static final int STATUS_PURCHASER_CANCEL_AFTER_PAY = 11;

    public static final int STATUS_WAITING_OTHER_SHIP = 12;

    // 1-立即配送 2-定时配送
    public static final int SHIP_TYPE_NOW = 1;

    public static final int SHIP_TYPE_TIMING = 2;

    // 配送方式 1-蜂鸟 2-达达 3-美团 4-顺丰 5-商家配送
    public static final int SHIP_TYPE_SF = 4;

    public static final int SHIP_TYPE_SHOP_SELF = 5;

    /**
     * 订单行
     */
    private List<ExtTOrderLine> orderLines;

    /**
     * 店铺优惠券信息
     */
    private TPurchaserCoupon tPurchaserCoupon;

    /**
     * 用户红包信息
     */
    private TPurchaserEnvelope tPurchaserEnvelope;

    private String shopName;

    private ExtTPurchaser tPurchaser;

    /**
     * 配送地址
     */
    private Long purchaserAddressId;

    private BigDecimal distance;

    private List<TOrderLog> logs;

    private BigDecimal orderRate;

    public List<ExtTOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<ExtTOrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public TPurchaserCoupon gettPurchaserCoupon() {
        return tPurchaserCoupon;
    }

    public void settPurchaserCoupon(TPurchaserCoupon tPurchaserCoupon) {
        this.tPurchaserCoupon = tPurchaserCoupon;
    }

    public TPurchaserEnvelope gettPurchaserEnvelope() {
        return tPurchaserEnvelope;
    }

    public void settPurchaserEnvelope(TPurchaserEnvelope tPurchaserEnvelope) {
        this.tPurchaserEnvelope = tPurchaserEnvelope;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ExtTPurchaser gettPurchaser() {
        return tPurchaser;
    }

    public void settPurchaser(ExtTPurchaser tPurchaser) {
        this.tPurchaser = tPurchaser;
    }

    public Long getPurchaserAddressId() {
        return purchaserAddressId;
    }

    public void setPurchaserAddressId(Long purchaserAddressId) {
        this.purchaserAddressId = purchaserAddressId;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public List<TOrderLog> getLogs() {
        return logs;
    }

    public void setLogs(List<TOrderLog> logs) {
        this.logs = logs;
    }

    public BigDecimal getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(BigDecimal orderRate) {
        this.orderRate = orderRate;
    }
}
