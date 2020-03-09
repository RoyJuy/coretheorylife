package com.coretheorylife.modules.shop.websocket.entiry;

public class ShopOrderSocketEntity {

    // token失效
    public static final int TYPE_TOKEN_INVALID = 0;

    // 新订单
    public static final int TYPE_NEW_ORDER = 1;

    // 催单
    public static final int TYPE_URGE_ORDER = 2;

    // 用户取消订单
    public static final int TYPE_CANCEL_ORDER = 3;

    // 订单状态改变
    public static final int TYPE_STATUS_CHANGE = 4;

    // 客户端发送的心跳包回复
    public static final int TYPE_HEARTBEAT_CLIENT = 5;

    // 服务器发送的心跳包等待
    public static final int TYPE_HEARTBEAT_SERVER = 6;

    // 消息确认
    public static final int TYPE_MESSAGE_CONFIRM = 7;

    private String messageId;

    private int code;

    private String message;

    private int type;

    private long orderId;

    private int fromStatus;

    private int toStatus;

    private int fromShipStatus;

    private int toShipStatus;

    public int getFromShipStatus() {
        return fromShipStatus;
    }

    public void setFromShipStatus(int fromShipStatus) {
        this.fromShipStatus = fromShipStatus;
    }

    public int getToShipStatus() {
        return toShipStatus;
    }

    public void setToShipStatus(int toShipStatus) {
        this.toShipStatus = toShipStatus;
    }

    public int getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(int fromStatus) {
        this.fromStatus = fromStatus;
    }

    public int getToStatus() {
        return toStatus;
    }

    public void setToStatus(int toStatus) {
        this.toStatus = toStatus;
    }

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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
