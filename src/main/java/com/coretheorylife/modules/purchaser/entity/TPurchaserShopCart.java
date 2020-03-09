package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TPurchaserShopCart extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 食物id
     */
    private Long goodsId;

    /**
     * 数量
     */
    private Integer number;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumberDefaultValue() {
        return number == null ? 1 : number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}