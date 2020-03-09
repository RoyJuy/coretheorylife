package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TGoodsNutritionUVO {
    /**
     * 主键id
     */
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 食物
     */
    private String name;

    /**
     * 蛋白质/1g
     */
    private BigDecimal protein;

    /**
     * 碳水/1g
     */
    private BigDecimal carbohydrate;

    /**
     * 脂肪/1g
     */
    private BigDecimal adipose;

    /**
     * Kacl/1g
     */
    private BigDecimal kacl;

    /**
     * 是否已确认数据 1-是 0-不是
     */
    private Integer status;

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

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public BigDecimal getAdipose() {
        return adipose;
    }

    public void setAdipose(BigDecimal adipose) {
        this.adipose = adipose;
    }

    public BigDecimal getKacl() {
        return kacl;
    }

    public void setKacl(BigDecimal kacl) {
        this.kacl = kacl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}