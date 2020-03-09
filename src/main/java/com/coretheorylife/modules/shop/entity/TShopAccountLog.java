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
public class TShopAccountLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 1-提现 2-结算
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
     * 顺丰订单号
     */
    private String sfOrderId;

    /**
     * 配送距离，单位米
     */
    private Integer shipDistance;

    /**
     * 1-待审核 2-已审核 3-已拒绝
     */
    private Integer status;

    /**
     * 平台扣除金额
     */
    private BigDecimal sysAmount;

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

    public Integer getStatusDefaultValue() {
        return status == null ? 1 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getSysAmountDefaultValue() {
        return sysAmount == null ? new BigDecimal("0.00") : sysAmount;
    }

    public BigDecimal getSysAmount() {
        return sysAmount;
    }

    public void setSysAmount(BigDecimal sysAmount) {
        this.sysAmount = sysAmount;
    }
}