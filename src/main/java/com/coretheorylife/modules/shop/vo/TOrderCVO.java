package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TOrderCVO {

    @NotNull(message = "店铺id不能为空")
    private Long shopId;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 1-立即配送 2-定时配送
     */
    @NotNull(message = "配送方式不能为空")
    private Integer shipType;

    /**
     * 定时配送时间
     */
    private Date shipTime;

    /**
     * 配送地址
     */
    @NotNull(message = "配送地址不能为空")
    private Long purchaserAddressId;

    /**
     * 用餐人数
     */
    @NotNull(message = "用餐人数不能为空")
    @Max(value = 999, message = "最大值不能超过999")
    @Min(value = 1, message = "最小值不能小于1")
    private Integer eatNumber;

    /**
     * 订单行
     */
    @Valid
    @NotEmpty(message = "商品不能为空")
    private List<TOrderLineCVO> orderLines;

    /**
     * 店铺优惠券id
     */
    private Long purchaserCouponId;

    /**
     * 用户红包id
     */
    private Long purchaserEnvelopeId;

    /**
     * 前端计算的实际支付
     */
    @DecimalMin(value = "0", message = "前端计算的支付金额必须大于0")
    @DecimalMax(value = "999999", message = "最大支付金额不可以超过999999")
    @NotNull(message = "前端计算的实际支付金额不能为空")
    private BigDecimal payPrice;

    /**
     * 前端计算的总价
     */
    @DecimalMin(value = "0", message = "前端计算的总价必须大于0")
    @DecimalMax(value = "999999", message = "最大总价不可以超过999999")
    @NotNull(message = "前端计算的总价不能为空")
    private BigDecimal price;

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public Long getPurchaserAddressId() {
        return purchaserAddressId;
    }

    public void setPurchaserAddressId(Long purchaserAddressId) {
        this.purchaserAddressId = purchaserAddressId;
    }

    public Integer getEatNumber() {
        return eatNumber;
    }

    public void setEatNumber(Integer eatNumber) {
        this.eatNumber = eatNumber;
    }

    public List<TOrderLineCVO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<TOrderLineCVO> orderLines) {
        this.orderLines = orderLines;
    }

    public Long getPurchaserCouponId() {
        return purchaserCouponId;
    }

    public void setPurchaserCouponId(Long purchaserCouponId) {
        this.purchaserCouponId = purchaserCouponId;
    }

    public Long getPurchaserEnvelopeId() {
        return purchaserEnvelopeId;
    }

    public void setPurchaserEnvelopeId(Long purchaserEnvelopeId) {
        this.purchaserEnvelopeId = purchaserEnvelopeId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }
}
