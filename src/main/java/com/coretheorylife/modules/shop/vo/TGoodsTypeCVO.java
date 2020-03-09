package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

public class TGoodsTypeCVO {
    /**
     * 货架名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 排序 越大越靠前 最大999
     */
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}