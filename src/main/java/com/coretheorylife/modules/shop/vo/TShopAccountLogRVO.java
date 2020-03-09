package com.coretheorylife.modules.shop.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TShopAccountLogRVO {
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
     * 可提现金额
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
     * 银行卡id（必须是自己的银行卡）
     */
    private Long bankId;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getSysAmount() {
        return sysAmount;
    }

    public void setSysAmount(BigDecimal sysAmount) {
        this.sysAmount = sysAmount;
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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
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
}