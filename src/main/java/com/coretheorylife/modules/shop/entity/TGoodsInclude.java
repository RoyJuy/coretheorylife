package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TGoodsInclude extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品id
     */
    private Long shopGoodsId;

    /**
     * 商品原材料id
     */
    private Long goodsNutritionId;

    /**
     * 排序 越大越靠前 最大999
     */
    private Integer sort;

    /**
     * 含量/g
     */
    private Integer weight;

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

    public Long getShopGoodsId() {
        return shopGoodsId;
    }

    public void setShopGoodsId(Long shopGoodsId) {
        this.shopGoodsId = shopGoodsId;
    }

    public Long getGoodsNutritionId() {
        return goodsNutritionId;
    }

    public void setGoodsNutritionId(Long goodsNutritionId) {
        this.goodsNutritionId = goodsNutritionId;
    }

    public Integer getSortDefaultValue() {
        return sort == null ? 0 : sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}