package com.coretheorylife.modules.purchaser.websocket.entiry;

public class PurchaserOrderSocketEntity {

    // token失效
    public static final int TYPE_TOKEN_INVALID = 0;

    // 订单拒绝
    public static final int TYPE_REJECT_ORDER = 1;

    // 接受订单
    public static final int TYPE_RECEIVE_ORDER = 2;

    private int code;

    private String message;

    private int type;

    private long orderId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
