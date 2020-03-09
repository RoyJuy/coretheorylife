package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TGoodsInclude;

public class ExtTGoodsInclude extends TGoodsInclude {
    private Long goodsNutritionId;

    @Override
    public Long getGoodsNutritionId() {
        return goodsNutritionId;
    }

    @Override
    public void setGoodsNutritionId(Long goodsNutritionId) {
        this.goodsNutritionId = goodsNutritionId;
    }
}
