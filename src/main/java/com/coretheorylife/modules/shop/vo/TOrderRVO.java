package com.coretheorylife.modules.shop.vo;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.vo.TPurchaserCouponRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserEnvelopeRVO;
import com.coretheorylife.modules.shop.entity.TOrderLog;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TOrderRVO {

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
     * 配送方式 1-蜂鸟 2-达达 3-美团
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
     * 用餐人数
     */
    private Integer eatNumber;

    /**
     * 送达时间
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
     * 预期送达时间
     */
    private Date expectedShipTime;

    /**
     * 订单状态 1-待付款 2-付款成功 3-进行中 4-已完成 5-用户已取消 6-商家已拒绝 7-已退款
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Long createUser;

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Boolean deleteFlag;

    /**
     * 订单行
     */
    private List<TOrderLineRVO> orderLines;

    /**
     * 店铺优惠券信息
     */
    private TPurchaserCouponRVO tPurchaserCoupon;

    /**
     * 用户红包信息
     */
    private TPurchaserEnvelopeRVO tPurchaserEnvelope;

    private String shopName;

    private ExtTPurchaser tPurchaser;

    /**
     * 收货人名称
     */
    private String receiverMobile;

    /**
     * 收货人电话
     */
    private String receiverName;

    private BigDecimal distance;

    private Integer orderCount;

    private List<TOrderLogRVO> logs;

    /**
     * 超时未支付多少分钟取消订单
     */
    private Integer payTimeout;

    /**
     * 超时未接单多少分钟取消订单
     */
    private Integer receiverTimeout;

    private BigDecimal orderRate;

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
     * 顺丰订单号
     */
    private String sfOrderId;

    /**
     * 配送距离，单位米
     */
    private Integer shipDistance;

    public String getSfOrderId() {
        return sfOrderId;
    }

    public void setSfOrderId(String sfOrderId) {
        this.sfOrderId = sfOrderId;
    }

    public Integer getShipDistance() {
        return shipDistance;
    }

    public void setShipDistance(Integer shipDistance) {
        this.shipDistance = shipDistance;
    }

    public Boolean getShipSelf() {
        return shipSelf;
    }

    public void setShipSelf(Boolean shipSelf) {
        this.shipSelf = shipSelf;
    }

    public BigDecimal getSendShipFee() {
        return sendShipFee;
    }

    public void setSendShipFee(BigDecimal sendShipFee) {
        this.sendShipFee = sendShipFee;
    }

    public BigDecimal getShopShipFee() {
        return shopShipFee;
    }

    public void setShopShipFee(BigDecimal shopShipFee) {
        this.shopShipFee = shopShipFee;
    }

    public Integer getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(Integer payTimeout) {
        this.payTimeout = payTimeout;
    }

    public Integer getReceiverTimeout() {
        return receiverTimeout;
    }

    public void setReceiverTimeout(Integer receiverTimeout) {
        this.receiverTimeout = receiverTimeout;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public BigDecimal getShipFee() {
        return shipFee;
    }

    public void setShipFee(BigDecimal shipFee) {
        this.shipFee = shipFee;
    }

    public Integer getShipPlatform() {
        return shipPlatform;
    }

    public void setShipPlatform(Integer shipPlatform) {
        this.shipPlatform = shipPlatform;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public String getShipPerson() {
        return shipPerson;
    }

    public void setShipPerson(String shipPerson) {
        this.shipPerson = shipPerson;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
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

    public Integer getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Integer shipStatus) {
        this.shipStatus = shipStatus;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
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

    public List<TOrderLineRVO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<TOrderLineRVO> orderLines) {
        this.orderLines = orderLines;
    }

    public TPurchaserCouponRVO gettPurchaserCoupon() {
        return tPurchaserCoupon;
    }

    public void settPurchaserCoupon(TPurchaserCouponRVO tPurchaserCoupon) {
        this.tPurchaserCoupon = tPurchaserCoupon;
    }

    public TPurchaserEnvelopeRVO gettPurchaserEnvelope() {
        return tPurchaserEnvelope;
    }

    public void settPurchaserEnvelope(TPurchaserEnvelopeRVO tPurchaserEnvelope) {
        this.tPurchaserEnvelope = tPurchaserEnvelope;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getShipPrefix() {
        return shipPrefix;
    }

    public void setShipPrefix(String shipPrefix) {
        this.shipPrefix = shipPrefix;
    }

    public String getShipSuffix() {
        return shipSuffix;
    }

    public void setShipSuffix(String shipSuffix) {
        this.shipSuffix = shipSuffix;
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

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public List<TOrderLogRVO> getLogs() {
        return logs;
    }

    public void setLogs(List<TOrderLogRVO> logs) {
        this.logs = logs;
    }

    public BigDecimal getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(BigDecimal orderRate) {
        this.orderRate = orderRate;
    }
}
