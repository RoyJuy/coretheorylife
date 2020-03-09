package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

public class TGoodsNutritionCVO {
    /**
     * 食物
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}