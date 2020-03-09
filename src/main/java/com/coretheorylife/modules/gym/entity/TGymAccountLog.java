package com.coretheorylife.modules.gym.entity;

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
public class TGymAccountLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 健身房id
     */
    private Long gymId;

    /**
     * 教练id
     */
    private Long coachId;

    /**
     * 1-提现 2-结算 3-教练解绑金额
     */
    private Integer type;

    /**
     * 提现金额
     */
    private BigDecimal amount;

    /**
     * 结算金额
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
     * 银行卡id（必须是自己的银行卡）
     */
    private Long bankId;

    /**
     * 1-待审核 2-已审核 3-已拒绝
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
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
}