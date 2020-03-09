package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TShopShipLog extends BaseBean implements Serializable {
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
     * 系统订单号
     */
    private String shopOrderId;

    /**
     * SF订单id
     */
    private String sfOrderId;

    /**
     * 顺丰运单号
     */
    private String sfBillId;

    /**
     * 推送时间
     */
    private String pushTime;

    /**
     * 商品总价格
     */
    private BigDecimal totalPrice;

    /**
     * 配送距离
     */
    private BigDecimal deliveryDistanceMeter;

    /**
     * 商品重量
     */
    private Integer weightGram;

    /**
     * 起送时间
     */
    private Integer startTime;

    /**
     * 期望送达时间
     */
    private Integer expectTime;

    /**
     * 支付费用
     */
    private BigDecimal totalPayMoney;

    /**
     * 实际支付金额
     */
    private BigDecimal realPayMoney;

    /**
     * 优惠券总金额
     */
    private BigDecimal couponsTotalFee;

    /**
     * 结算方式
     */
    private Integer settlementType;

    /**
     * 1-扣费 2-不扣费
     */
    private Integer status;

    /**
     * 扣费描述
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

    public String getShopOrderIdDefaultValue() {
        return shopOrderId == null ? "" : shopOrderId;
    }

    public String getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(String shopOrderId) {
        this.shopOrderId = shopOrderId == null ? null : shopOrderId.trim();
    }

    public String getSfOrderIdDefaultValue() {
        return sfOrderId == null ? "" : sfOrderId;
    }

    public String getSfOrderId() {
        return sfOrderId;
    }

    public void setSfOrderId(String sfOrderId) {
        this.sfOrderId = sfOrderId == null ? null : sfOrderId.trim();
    }

    public String getSfBillIdDefaultValue() {
        return sfBillId == null ? "" : sfBillId;
    }

    public String getSfBillId() {
        return sfBillId;
    }

    public void setSfBillId(String sfBillId) {
        this.sfBillId = sfBillId == null ? null : sfBillId.trim();
    }

    public String getPushTimeDefaultValue() {
        return pushTime == null ? "" : pushTime;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime == null ? null : pushTime.trim();
    }

    public BigDecimal getTotalPriceDefaultValue() {
        return totalPrice == null ? new BigDecimal("0.00") : totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDeliveryDistanceMeterDefaultValue() {
        return deliveryDistanceMeter == null ? new BigDecimal("0.00") : deliveryDistanceMeter;
    }

    public BigDecimal getDeliveryDistanceMeter() {
        return deliveryDistanceMeter;
    }

    public void setDeliveryDistanceMeter(BigDecimal deliveryDistanceMeter) {
        this.deliveryDistanceMeter = deliveryDistanceMeter;
    }

    public Integer getWeightGramDefaultValue() {
        return weightGram == null ? 0 : weightGram;
    }

    public Integer getWeightGram() {
        return weightGram;
    }

    public void setWeightGram(Integer weightGram) {
        this.weightGram = weightGram;
    }

    public Integer getStartTimeDefaultValue() {
        return startTime == null ? 0 : startTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getExpectTimeDefaultValue() {
        return expectTime == null ? 0 : expectTime;
    }

    public Integer getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Integer expectTime) {
        this.expectTime = expectTime;
    }

    public BigDecimal getTotalPayMoneyDefaultValue() {
        return totalPayMoney == null ? new BigDecimal("0.00") : totalPayMoney;
    }

    public BigDecimal getTotalPayMoney() {
        return totalPayMoney;
    }

    public void setTotalPayMoney(BigDecimal totalPayMoney) {
        this.totalPayMoney = totalPayMoney;
    }

    public BigDecimal getRealPayMoneyDefaultValue() {
        return realPayMoney == null ? new BigDecimal("0.00") : realPayMoney;
    }

    public BigDecimal getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(BigDecimal realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public BigDecimal getCouponsTotalFeeDefaultValue() {
        return couponsTotalFee == null ? new BigDecimal("0.00") : couponsTotalFee;
    }

    public BigDecimal getCouponsTotalFee() {
        return couponsTotalFee;
    }

    public void setCouponsTotalFee(BigDecimal couponsTotalFee) {
        this.couponsTotalFee = couponsTotalFee;
    }

    public Integer getSettlementTypeDefaultValue() {
        return settlementType == null ? 1 : settlementType;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    public Integer getStatusDefaultValue() {
        return status == null ? 1 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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