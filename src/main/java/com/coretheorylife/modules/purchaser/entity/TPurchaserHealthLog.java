package com.coretheorylife.modules.purchaser.entity;

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
public class TPurchaserHealthLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 日期格式为yyyy-MM-dd
     */
    private Date logTime;

    /**
     * 蛋白质
     */
    private BigDecimal protein;

    /**
     * 碳水
     */
    private BigDecimal carbohydrate;

    /**
     * 脂肪
     */
    private BigDecimal adipose;

    /**
     * Kacl
     */
    private BigDecimal kacl;

    /**
     * 总预算蛋白质
     */
    private BigDecimal allProtein;

    /**
     * 总预算碳水
     */
    private BigDecimal allCarbohydrate;

    /**
     * 总预算脂肪
     */
    private BigDecimal allAdipose;

    /**
     * 总预算Kacl
     */
    private BigDecimal allKacl;

    /**
     * 当天总共吃的蛋白质
     */
    private BigDecimal allDayProtein;

    /**
     * 当天总共吃的碳水
     */
    private BigDecimal allDayCarbohydrate;

    /**
     * 当天总共吃的脂肪
     */
    private BigDecimal allDayAdipose;

    /**
     * 当天总共吃的Kacl
     */
    private BigDecimal allDayKacl;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public BigDecimal getProteinDefaultValue() {
        return protein == null ? new BigDecimal("0.000") : protein;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrateDefaultValue() {
        return carbohydrate == null ? new BigDecimal("0.000") : carbohydrate;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public BigDecimal getAdiposeDefaultValue() {
        return adipose == null ? new BigDecimal("0.000") : adipose;
    }

    public BigDecimal getAdipose() {
        return adipose;
    }

    public void setAdipose(BigDecimal adipose) {
        this.adipose = adipose;
    }

    public BigDecimal getKaclDefaultValue() {
        return kacl == null ? new BigDecimal("0.000") : kacl;
    }

    public BigDecimal getKacl() {
        return kacl;
    }

    public void setKacl(BigDecimal kacl) {
        this.kacl = kacl;
    }

    public BigDecimal getAllProteinDefaultValue() {
        return allProtein == null ? new BigDecimal("0.000") : allProtein;
    }

    public BigDecimal getAllProtein() {
        return allProtein;
    }

    public void setAllProtein(BigDecimal allProtein) {
        this.allProtein = allProtein;
    }

    public BigDecimal getAllCarbohydrateDefaultValue() {
        return allCarbohydrate == null ? new BigDecimal("0.000") : allCarbohydrate;
    }

    public BigDecimal getAllCarbohydrate() {
        return allCarbohydrate;
    }

    public void setAllCarbohydrate(BigDecimal allCarbohydrate) {
        this.allCarbohydrate = allCarbohydrate;
    }

    public BigDecimal getAllAdiposeDefaultValue() {
        return allAdipose == null ? new BigDecimal("0.000") : allAdipose;
    }

    public BigDecimal getAllAdipose() {
        return allAdipose;
    }

    public void setAllAdipose(BigDecimal allAdipose) {
        this.allAdipose = allAdipose;
    }

    public BigDecimal getAllKaclDefaultValue() {
        return allKacl == null ? new BigDecimal("0.000") : allKacl;
    }

    public BigDecimal getAllKacl() {
        return allKacl;
    }

    public void setAllKacl(BigDecimal allKacl) {
        this.allKacl = allKacl;
    }

    public BigDecimal getAllDayProteinDefaultValue() {
        return allDayProtein == null ? new BigDecimal("0.000") : allDayProtein;
    }

    public BigDecimal getAllDayProtein() {
        return allDayProtein;
    }

    public void setAllDayProtein(BigDecimal allDayProtein) {
        this.allDayProtein = allDayProtein;
    }

    public BigDecimal getAllDayCarbohydrateDefaultValue() {
        return allDayCarbohydrate == null ? new BigDecimal("0.000") : allDayCarbohydrate;
    }

    public BigDecimal getAllDayCarbohydrate() {
        return allDayCarbohydrate;
    }

    public void setAllDayCarbohydrate(BigDecimal allDayCarbohydrate) {
        this.allDayCarbohydrate = allDayCarbohydrate;
    }

    public BigDecimal getAllDayAdiposeDefaultValue() {
        return allDayAdipose == null ? new BigDecimal("0.000") : allDayAdipose;
    }

    public BigDecimal getAllDayAdipose() {
        return allDayAdipose;
    }

    public void setAllDayAdipose(BigDecimal allDayAdipose) {
        this.allDayAdipose = allDayAdipose;
    }

    public BigDecimal getAllDayKaclDefaultValue() {
        return allDayKacl == null ? new BigDecimal("0.000") : allDayKacl;
    }

    public BigDecimal getAllDayKacl() {
        return allDayKacl;
    }

    public void setAllDayKacl(BigDecimal allDayKacl) {
        this.allDayKacl = allDayKacl;
    }
}