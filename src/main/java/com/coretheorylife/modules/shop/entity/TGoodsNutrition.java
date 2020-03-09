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
public class TGoodsNutrition extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 食物
     */
    private String name;

    /**
     * 蛋白质/1g
     */
    private BigDecimal protein;

    /**
     * 碳水/1g
     */
    private BigDecimal carbohydrate;

    /**
     * 脂肪/1g
     */
    private BigDecimal adipose;

    /**
     * Kacl/1g
     */
    private BigDecimal kacl;

    /**
     * 是否已确认数据 1-是 0-不是
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopIdDefaultValue() {
        return shopId == null ? 0L : shopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getNameDefaultValue() {
        return name == null ? "" : name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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