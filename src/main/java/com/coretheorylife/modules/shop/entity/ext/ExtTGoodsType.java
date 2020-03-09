package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TGoodsType;

import java.util.List;

public class ExtTGoodsType extends TGoodsType {

    private List<ExtTGoods> goods;

    public List<ExtTGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<ExtTGoods> goods) {
        this.goods = goods;
    }
}
