package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TOrderLine;

import java.util.List;

public class ExtTOrderLine extends TOrderLine {
    /**
     * 订单行里面的产品 一对一的
     */
    private ExtTGoods goods;

    /**
     * 商品规格属性
     */
    private List<Long> tGoodsSelectIds;

    public ExtTGoods getGoods() {
        return goods;
    }

    public void setGoods(ExtTGoods goods) {
        this.goods = goods;
    }

    public List<Long> gettGoodsSelectIds() {
        return tGoodsSelectIds;
    }

    public void settGoodsSelectIds(List<Long> tGoodsSelectIds) {
        this.tGoodsSelectIds = tGoodsSelectIds;
    }
}
