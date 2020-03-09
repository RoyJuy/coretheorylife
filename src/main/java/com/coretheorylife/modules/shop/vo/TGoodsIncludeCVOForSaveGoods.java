package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TGoodsIncludeCVOForSaveGoods {

    @NotNull(message = "组成不能为空")
    private Long goodsNutritionId;

    /**
     * 含量/g
     */
    @Min(value = 1, message = "含量不能小于1")
    @Max(value = 999999, message = "含量不能大于999999")
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
