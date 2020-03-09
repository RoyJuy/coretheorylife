package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.NotNull;

public class TGoodsTypeUVO {
    /**
     * 主键id
     */
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 货架名称
     */
    private String name;

    /**
     * 排序 越大越靠前 最大999
     */
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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