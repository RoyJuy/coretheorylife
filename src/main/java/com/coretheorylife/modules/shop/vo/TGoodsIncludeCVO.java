package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.NotNull;

public class TGoodsIncludeCVO {

    /**
     * 商品原材料id
     */
    @NotNull(message = "原材料不能为空")
    private Long goodsNutritionId;

    /**
     * 排序 越大越靠前 最大999
     */
    private Integer sort;

    /**
     * 含量/g
     */
    private Integer weight;

    public Long getGoodsNutritionId() {
        return goodsNutritionId;
    }

    public void setGoodsNutritionId(Long goodsNutritionId) {
        this.goodsNutritionId = goodsNutritionId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
