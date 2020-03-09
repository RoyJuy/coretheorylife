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
public class TGoodsSelect extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品标签id
     */
    private Long goodsLabelId;

    /**
     * 商品原材料id
     */
    private Long goodsNutritionId;

    /**
     * 名称
     */
    private String name;

    /**
     * 重量
     */
    private Integer weight;

    /**
     * 排序1-999 越大越靠前
     */
    private Integer sort;

    /**
     * 价格
     */
    private BigDecimal price;

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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsLabelId() {
        return goodsLabelId;
    }

    public void setGoodsLabelId(Long goodsLabelId) {
        this.goodsLabelId = goodsLabelId;
    }

    public Long getGoodsNutritionId() {
        return goodsNutritionId;
    }

    public void setGoodsNutritionId(Long goodsNutritionId) {
        this.goodsNutritionId = goodsNutritionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getSortDefaultValue() {
        return sort == null ? 1 : sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getPriceDefaultValue() {
        return price == null ? new BigDecimal("0.000") : price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}