package com.coretheorylife.modules.shop.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wcyong
 * @date 2019-11-29
 */
public class TGoodsSelectRVO {
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
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public BigDecimal getAdipose() {
        return adipose;
    }

    public void setAdipose(BigDecimal adipose) {
        this.adipose = adipose;
    }

    public BigDecimal getKacl() {
        return kacl;
    }

    public void setKacl(BigDecimal kacl) {
        this.kacl = kacl;
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