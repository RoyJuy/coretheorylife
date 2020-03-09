package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsSelect;

import java.util.List;

public class ExtTGoodsLabel extends TGoodsLabel {
    /**
     * 商品规格列表
     */
    private List<ExtTGoodsSelect> goodsSelects;

    public List<ExtTGoodsSelect> getGoodsSelects() {
        return goodsSelects;
    }

    public void setGoodsSelects(List<ExtTGoodsSelect> goodsSelects) {
        this.goodsSelects = goodsSelects;
    }
}
