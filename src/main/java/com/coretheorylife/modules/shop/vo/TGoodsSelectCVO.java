package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author wcyong
 * @date 2019-11-29
 */
public class TGoodsSelectCVO {

    @NotBlank(message = "name不能为空")
    private String name;

    /**
     * 商品原材料id
     */
    @NotNull(message = "商品原材料不能为空")
    private Long goodsNutritionId;

    /**
     * 重量
     */
    @Max(value = 999999, message = "重量范围为1-999999")
    @Min(value = 0, message = "重量范围为1-999999")
    @NotNull(message = "重量不能为空")
    private Integer weight;

    /**
     * 排序1-999 越大越靠前
     */
    @Max(value = 999, message = "排序范围为1-999")
    @Min(value = 1, message = "排序范围为1-999")
    private Integer sort;

    /**
     * 价格
     */
    @DecimalMin(value = "0", message = "金额必须大于0")
    @DecimalMax(value = "999999", message = "金额不可以超过999999")
    @NotNull(message = "price不能为空")
    private BigDecimal price;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}