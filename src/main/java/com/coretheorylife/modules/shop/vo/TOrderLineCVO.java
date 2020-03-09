package com.coretheorylife.modules.shop.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TOrderLineCVO {
    /**
     * 货物id
     */
    @NotNull(message = "产品id不能为空")
    private Long goodsId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    @Max(value = 999, message = "最大值不能超过999")
    @Min(value = 1, message = "最小值不能小于1")
    private Integer number;

    private List<Long> tGoodsSelectIds;

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

    public List<Long> gettGoodsSelectIds() {
        return tGoodsSelectIds;
    }

    public void settGoodsSelectIds(List<Long> tGoodsSelectIds) {
        this.tGoodsSelectIds = tGoodsSelectIds;
    }
}
