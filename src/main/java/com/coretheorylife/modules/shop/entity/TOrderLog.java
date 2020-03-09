package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TOrderLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 配送状态 1-等待接单 2-商家已接单 3-已分配骑手 4-骑手已到店 5-配送中 6-已送达 7-异常 8-已取消
     */
    private Integer nowShipStatus;

    /**
     * 订单状态 1-待付款 2-付款成功 3-进行中 4-制作完成 5-已完成 6-用户已取消 7-商家已拒绝 8-申请退款中 8-已退款 10-退款已拒绝
     */
    private Integer nowStatus;

    /**
     * 配送状态 1-等待接单 2-商家已接单 3-已分配骑手 4-骑手已到店 5-配送中 6-已送达 7-异常 8-已取消
     */
    private Integer beforeShipStatus;

    /**
     * 订单状态 1-待付款 2-付款成功 3-进行中 4-制作完成 5-已完成 6-用户已取消 7-商家已拒绝 8-申请退款中 8-已退款 10-退款已拒绝
     */
    private Integer beforeStatus;

    /**
     * 计算为订单数量
     */
    private Boolean createOrderFlag;

    /**
     * 日志描述
     */
    private Integer code;

    /**
     * 日志代码
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Integer getNowShipStatusDefaultValue() {
        return nowShipStatus == null ? 1 : nowShipStatus;
    }

    public Integer getNowShipStatus() {
        return nowShipStatus;
    }

    public void setNowShipStatus(Integer nowShipStatus) {
        this.nowShipStatus = nowShipStatus;
    }

    public Integer getNowStatusDefaultValue() {
        return nowStatus == null ? 1 : nowStatus;
    }

    public Integer getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(Integer nowStatus) {
        this.nowStatus = nowStatus;
    }

    public Integer getBeforeShipStatusDefaultValue() {
        return beforeShipStatus == null ? 1 : beforeShipStatus;
    }

    public Integer getBeforeShipStatus() {
        return beforeShipStatus;
    }

    public void setBeforeShipStatus(Integer beforeShipStatus) {
        this.beforeShipStatus = beforeShipStatus;
    }

    public Integer getBeforeStatusDefaultValue() {
        return beforeStatus == null ? 1 : beforeStatus;
    }

    public Integer getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(Integer beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public Boolean getCreateOrderFlagDefaultValue() {
        return createOrderFlag == null ? false : createOrderFlag;
    }

    public Boolean getCreateOrderFlag() {
        return createOrderFlag;
    }

    public void setCreateOrderFlag(Boolean createOrderFlag) {
        this.createOrderFlag = createOrderFlag;
    }

    public Integer getCodeDefaultValue() {
        return code == null ? 1 : code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescriptionDefaultValue() {
        return description == null ? "" : description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}