package com.coretheorylife.modules.purchaser.entity;

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
public class TPurchaserAccountLog extends BaseBean implements Serializable {
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
     * 类型 1-消费 2-退款 3-提现 4-结算
     */
    private Integer type;

    /**
     * 银行卡id（必须是自己的银行卡）
     */
    private Long bankId;

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
     * 支付类型 0-不是支付记录 1-微信支付 2-支付宝支付
     */
    private Integer payType;

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

    public Integer getTypeDefaultValue() {
        return type == null ? 1 : type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getAmountDefaultValue() {
        return amount == null ? new BigDecimal("0.00") : amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getNotSettleAmountDefaultValue() {
        return notSettleAmount == null ? new BigDecimal("0.00") : notSettleAmount;
    }

    public BigDecimal getNotSettleAmount() {
        return notSettleAmount;
    }

    public void setNotSettleAmount(BigDecimal notSettleAmount) {
        this.notSettleAmount = notSettleAmount;
    }

    public BigDecimal getAmountAfterDefaultValue() {
        return amountAfter == null ? new BigDecimal("0.00") : amountAfter;
    }

    public BigDecimal getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(BigDecimal amountAfter) {
        this.amountAfter = amountAfter;
    }

    public BigDecimal getNotSettleAmountAfterDefaultValue() {
        return notSettleAmountAfter == null ? new BigDecimal("0.00") : notSettleAmountAfter;
    }

    public BigDecimal getNotSettleAmountAfter() {
        return notSettleAmountAfter;
    }

    public void setNotSettleAmountAfter(BigDecimal notSettleAmountAfter) {
        this.notSettleAmountAfter = notSettleAmountAfter;
    }

    public Integer getStatusDefaultValue() {
        return status == null ? 2 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrepayIdDefaultValue() {
        return prepayId == null ? "" : prepayId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
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
        return payType == null ? 0 : payType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}