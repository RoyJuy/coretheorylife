package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author wcyong
 * @date 2019-11-29
 */
public class TGoodsLabelCVO {
    /**
     * 商品另加类型的名称
     */
    @NotBlank(message = "规则名称不能为空")
    private String name;

    /**
     * 排序1-999 越大越靠前
     */
    @Max(value = 999, message = "排序范围为1-999")
    @Min(value = 1, message = "排序范围为1-999")
    private Integer sort;

    /**
     * 商品规格列表
     */
    @Valid
    private List<TGoodsSelectCVO> goodsSelects;

    public List<TGoodsSelectCVO> getGoodsSelects() {
        return goodsSelects;
    }

    public void setGoodsSelects(List<TGoodsSelectCVO> goodsSelects) {
        this.goodsSelects = goodsSelects;
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