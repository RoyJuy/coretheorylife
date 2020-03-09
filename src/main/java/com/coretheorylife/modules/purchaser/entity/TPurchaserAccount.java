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
public class TPurchaserAccount extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 教练/用户id
     */
    private Long purchaserId;

    /**
     * 可提现金额
     */
    private BigDecimal amount;

    /**
     * 待结算金额
     */
    private BigDecimal notSettleAmount;

    /**
     * 结算周期
     */
    private String settleTime;

    /**
     * 提现到账时间
     */
    private String withdrawalTime;

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

    public String getSettleTimeDefaultValue() {
        return settleTime == null ? "" : settleTime;
    }

    public String getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(String settleTime) {
        this.settleTime = settleTime == null ? null : settleTime.trim();
    }

    public String getWithdrawalTimeDefaultValue() {
        return withdrawalTime == null ? "" : withdrawalTime;
    }

    public String getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(String withdrawalTime) {
        this.withdrawalTime = withdrawalTime == null ? null : withdrawalTime.trim();
    }
}