package com.coretheorylife.modules.purchaser.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wcyong
 * @date 2019-11-26
 */
public class TPurchaserShopCartCVO {

    /**
     * 食物id
     */
    @NotNull(message = "goodsId不能为空")
    private Long goodsId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    @Min(value = 1, message = "数量必须大于0")
    @Max(value = 999, message = "数量必须小于999")
    private Integer number;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}