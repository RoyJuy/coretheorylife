package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TGoodsLog extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 订单id
     */
    private Long goodsId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 记录销量的月份yyyy-MM
     */
    private String logTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumberDefaultValue() {
        return number == null ? 0 : number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLogTimeDefaultValue() {
        return logTime == null ? "" : logTime;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime == null ? null : logTime.trim();
    }
}