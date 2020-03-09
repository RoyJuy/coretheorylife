package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TOrder extends BaseBean implements Serializable {

    private String order_id;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 支付方式 1-微信支付 2-支付宝支付
     */
    private Integer payType;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 实付价格
     */
    private BigDecimal payPrice;

    /**
     * 包装费
     */
    private BigDecimal packageFee;

    /**
     * 配送费
     */
    private BigDecimal shipFee;

    /**
     * 配送方式 1-蜂鸟 2-达达 3-美团 4-顺丰
     */
    private Integer shipPlatform;

    /**
     * 1-立即配送 2-定时配送
     */
    private Integer shipType;

    /**
     * 配送人
     */
    private String shipPerson;

    /**
     * 配送电话
     */
    private String shipNumber;

    /**
     * 配送地址前缀
     */
    private String shipPrefix;

    /**
     * 配送地址后缀
     */
    private String shipSuffix;

    /**
     * 配送经度
     */
    private BigDecimal shipLongitude;

    /**
     * 配送纬度
     */
    private BigDecimal shipLatitude;

    /**
     * 收货人名称
     */
    private String receiverMobile;

    /**
     * 收货人电话
     */
    private String receiverName;

    /**
     * 用餐人数
     */
    private Integer eatNumber;

    /**
     * 定时配送时间
     */
    private Date shipTime;

    /**
     * 配送状态 1-等待接单 2-商家已接单 3-已分配骑手 4-骑手已到店 5-配送中 6-已送达 7-异常 8-已取消
     */
    private Integer shipStatus;

    /**
     * 催单标记
     */
    private Boolean urgeFlag;

    /**
     * 催单时间
     */
    private Date urgeTime;

    /**
     * 预期送达时间送达后就是送达时间
     */
    private Date expectedShipTime;

    /**
     * 订单状态 1-待付款 2-付款成功 3-进行中 4-制作完成 5-已完成 6-用户已取消 7-商家已拒绝 8-申请退款中 9-已退款 10-退款已拒绝 11-支付后取消
     */
    private Integer status;

    /**
     * 满减金额
     */
    private BigDecimal discountFee;

    /**
     * 满减描述
     */
    private String discountDescription;

    /**
     * 店铺优惠券id
     */
    private Long purchaserCouponId;

    /**
     * 用户红包id
     */
    private Long purchaserEnvelopeId;

    /**
     * 订单是否已评价
     */
    private Boolean hasRate;

    /**
     * 当天订单数量
     */
    private Integer orderCount;

    /**
     * 超时未支付多少分钟取消订单
     */
    private Integer payTimeout;

    /**
     * 超时未接单多少分钟取消订单
     */
    private Integer receiverTimeout;

    /**
     * 是否商家配送
     */
    private Boolean shipSelf;

    /**
     * 配合ship_self使用，如果非商家配送，这里填写替用户垫付的配送费
     */
    private BigDecimal sendShipFee;

    /**
     * 配合ship_self使用，如商家配送，这里填写商家的配送费
     */
    private BigDecimal shopShipFee;

    /**
     * 重量，单位g
     */
    private Integer weight;

    /**
     * 顺丰订单号
     */
    private String sfOrderId;

    /**
     * 配送距离，单位米
     */
    private Integer shipDistance;

    private static final long serialVersionUID = 1L;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

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

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getOrderNoDefaultValue() {
        return orderNo == null ? "" : orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getPayTypeDefaultValue() {
        return payType == null ? 1 : payType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getRemarkDefaultValue() {
        return remark == null ? "" : remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getPriceDefaultValue() {
        return price == null ? new BigDecimal("0.00") : price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayPriceDefaultValue() {
        return payPrice == null ? new BigDecimal("0.00") : payPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getPackageFeeDefaultValue() {
        return packageFee == null ? new BigDecimal("0.00") : packageFee;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public BigDecimal getShipFeeDefaultValue() {
        return shipFee == null ? new BigDecimal("0.00") : shipFee;
    }

    public BigDecimal getShipFee() {
        return shipFee;
    }

    public void setShipFee(BigDecimal shipFee) {
        this.shipFee = shipFee;
    }

    public Integer getShipPlatformDefaultValue() {
        return shipPlatform == null ? 4 : shipPlatform;
    }

    public Integer getShipPlatform() {
        return shipPlatform;
    }

    public void setShipPlatform(Integer shipPlatform) {
        this.shipPlatform = shipPlatform;
    }

    public Integer getShipTypeDefaultValue() {
        return shipType == null ? 1 : shipType;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public String getShipPersonDefaultValue() {
        return shipPerson == null ? "" : shipPerson;
    }

    public String getShipPerson() {
        return shipPerson;
    }

    public void setShipPerson(String shipPerson) {
        this.shipPerson = shipPerson == null ? null : shipPerson.trim();
    }

    public String getShipNumberDefaultValue() {
        return shipNumber == null ? "" : shipNumber;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber == null ? null : shipNumber.trim();
    }

    public String getShipPrefixDefaultValue() {
        return shipPrefix == null ? "" : shipPrefix;
    }

    public String getShipPrefix() {
        return shipPrefix;
    }

    public void setShipPrefix(String shipPrefix) {
        this.shipPrefix = shipPrefix == null ? null : shipPrefix.trim();
    }

    public String getShipSuffix() {
        return shipSuffix;
    }

    public void setShipSuffix(String shipSuffix) {
        this.shipSuffix = shipSuffix == null ? null : shipSuffix.trim();
    }

    public BigDecimal getShipLongitude() {
        return shipLongitude;
    }

    public void setShipLongitude(BigDecimal shipLongitude) {
        this.shipLongitude = shipLongitude;
    }

    public BigDecimal getShipLatitude() {
        return shipLatitude;
    }

    public void setShipLatitude(BigDecimal shipLatitude) {
        this.shipLatitude = shipLatitude;
    }

    public String getReceiverMobileDefaultValue() {
        return receiverMobile == null ? "" : receiverMobile;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverNameDefaultValue() {
        return receiverName == null ? "" : receiverName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public Integer getEatNumberDefaultValue() {
        return eatNumber == null ? 1 : eatNumber;
    }

    public Integer getEatNumber() {
        return eatNumber;
    }

    public void setEatNumber(Integer eatNumber) {
        this.eatNumber = eatNumber;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getShipStatusDefaultValue() {
        return shipStatus == null ? 1 : shipStatus;
    }

    public Integer getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Integer shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Boolean getUrgeFlagDefaultValue() {
        return urgeFlag == null ? false : urgeFlag;
    }

    public Boolean getUrgeFlag() {
        return urgeFlag;
    }

    public void setUrgeFlag(Boolean urgeFlag) {
        this.urgeFlag = urgeFlag;
    }

    public Date getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(Date urgeTime) {
        this.urgeTime = urgeTime;
    }

    public Date getExpectedShipTime() {
        return expectedShipTime;
    }

    public void setExpectedShipTime(Date expectedShipTime) {
        this.expectedShipTime = expectedShipTime;
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

    public BigDecimal getDiscountFeeDefaultValue() {
        return discountFee == null ? new BigDecimal("0") : discountFee;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public String getDiscountDescriptionDefaultValue() {
        return discountDescription == null ? "[]" : discountDescription;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription == null ? null : discountDescription.trim();
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

    public Boolean getHasRateDefaultValue() {
        return hasRate == null ? false : hasRate;
    }

    public Boolean getHasRate() {
        return hasRate;
    }

    public void setHasRate(Boolean hasRate) {
        this.hasRate = hasRate;
    }

    public Integer getOrderCountDefaultValue() {
        return orderCount == null ? 1 : orderCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getPayTimeoutDefaultValue() {
        return payTimeout == null ? 1 : payTimeout;
    }

    public Integer getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(Integer payTimeout) {
        this.payTimeout = payTimeout;
    }

    public Integer getReceiverTimeoutDefaultValue() {
        return receiverTimeout == null ? 1 : receiverTimeout;
    }

    public Integer getReceiverTimeout() {
        return receiverTimeout;
    }

    public void setReceiverTimeout(Integer receiverTimeout) {
        this.receiverTimeout = receiverTimeout;
    }

    public Boolean getShipSelfDefaultValue() {
        return shipSelf == null ? false : shipSelf;
    }

    public Boolean getShipSelf() {
        return shipSelf;
    }

    public void setShipSelf(Boolean shipSelf) {
        this.shipSelf = shipSelf;
    }

    public BigDecimal getSendShipFeeDefaultValue() {
        return sendShipFee == null ? new BigDecimal("0.00") : sendShipFee;
    }

    public BigDecimal getSendShipFee() {
        return sendShipFee;
    }

    public void setSendShipFee(BigDecimal sendShipFee) {
        this.sendShipFee = sendShipFee;
    }

    public BigDecimal getShopShipFeeDefaultValue() {
        return shopShipFee == null ? new BigDecimal("0.00") : shopShipFee;
    }

    public BigDecimal getShopShipFee() {
        return shopShipFee;
    }

    public void setShopShipFee(BigDecimal shopShipFee) {
        this.shopShipFee = shopShipFee;
    }

    public Integer getWeightDefaultValue() {
        return weight == null ? 0 : weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public Integer getShipDistanceDefaultValue() {
        return shipDistance == null ? 0 : shipDistance;
    }

    public Integer getShipDistance() {
        return shipDistance;
    }

    public void setShipDistance(Integer shipDistance) {
        this.shipDistance = shipDistance;
    }
}