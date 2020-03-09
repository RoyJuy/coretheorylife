package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.NotNull;

public class TGoodsIncludeUVOForUpdateGoods {

    @NotNull(message = "组成不能为空")
    private Long goodsNutritionId;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
