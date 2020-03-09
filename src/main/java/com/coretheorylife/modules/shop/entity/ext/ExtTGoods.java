package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TGoods;

import java.util.List;

public class ExtTGoods extends TGoods {

    //商品状态 1-待上架 2-已上架 3-已下架
    public static final int STATUS_WAIT_SHELF = 1;

    public static final int STATUS_SHELF = 2;

    public static final int STATUS_OBTAINED = 3;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 食材成分表
     */
    private List<ExtTGoodsNutrition> nutritions;

    /**
     * 商品组成
     */
    private List<ExtTGoodsInclude> tGoodsIncludes;

    /**
     * 商品规格列表
     */
    private List<ExtTGoodsLabel> goodsLabels;

    private String shopName;

    public List<ExtTGoodsNutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(List<ExtTGoodsNutrition> nutritions) {
        this.nutritions = nutritions;
    }

    public List<ExtTGoodsInclude> gettGoodsIncludes() {
        return tGoodsIncludes;
    }

    public void settGoodsIncludes(List<ExtTGoodsInclude> tGoodsIncludes) {
        this.tGoodsIncludes = tGoodsIncludes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<ExtTGoodsLabel> getGoodsLabels() {
        return goodsLabels;
    }

    public void setGoodsLabels(List<ExtTGoodsLabel> goodsLabels) {
        this.goodsLabels = goodsLabels;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}