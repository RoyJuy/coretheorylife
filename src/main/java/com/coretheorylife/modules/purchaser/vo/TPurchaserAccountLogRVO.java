package com.coretheorylife.modules.purchaser.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TPurchaserAccountLogRVO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 类型 1-消费 2-退款
     */
    private Integer type;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 待结算金额
     */
    private BigDecimal notSettleAmount;

    /**
     * 执行操作后可提现金额
     */
    private BigDecimal amountAfter;

    /**
     * 执行操作后待结算金额
     */
    private BigDecimal notSettleAmountAfter;
    /**
     * 状态 1-待审核 2-已审核 3-已拒绝
     */
    private Integer status;

    /**
     * 预支付订单号，在线充值时有效
     */
    private String prepayId;

    /**
     * 	充值编号，在线充值有效
     */
    private String orderNo;

    /**
     * 支付类型 1-微信支付 2-支付宝支付
     */
    private Integer payType;

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
     * 银行卡id（必须是自己的银行卡）
     */
    private Long bankId;

    public BigDecimal getNotSettleAmount() {
        return notSettleAmount;
    }

    public void setNotSettleAmount(BigDecimal notSettleAmount) {
        this.notSettleAmount = notSettleAmount;
    }

    public BigDecimal getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(BigDecimal amountAfter) {
        this.amountAfter = amountAfter;
    }

    public BigDecimal getNotSettleAmountAfter() {
        return notSettleAmountAfter;
    }

    public void setNotSettleAmountAfter(BigDecimal notSettleAmountAfter) {
        this.notSettleAmountAfter = notSettleAmountAfter;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}
