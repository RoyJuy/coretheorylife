package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TOrderLine extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 货物id
     */
    private Long goodsId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 折扣率
     */
    private BigDecimal discountRate;

    /**
     * 折扣数量
     */
    private Integer discountNumber;

    /**
     * 商品规格
     */
    private String specification;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public BigDecimal getDiscountRateDefaultValue() {
        return discountRate == null ? new BigDecimal("1.00") : discountRate;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getDiscountNumberDefaultValue() {
        return discountNumber == null ? 0 : discountNumber;
    }

    public Integer getDiscountNumber() {
        return discountNumber;
    }

    public void setDiscountNumber(Integer discountNumber) {
        this.discountNumber = discountNumber;
    }

    public String getSpecificationDefaultValue() {
        return specification == null ? "[]" : specification;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }
}