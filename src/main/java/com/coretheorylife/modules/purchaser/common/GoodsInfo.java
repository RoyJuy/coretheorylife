package com.coretheorylife.modules.purchaser.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * GoodsInfo
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Data
public class GoodsInfo {

    private Integer number;

    private long shopCartId;

    private long id;

    private long shopId;

    private long shopTypeId;

    private String name;

    private long sort;

    private String pic;

    private String description;

    private String characteristic;

    private Integer status;

    private Integer minBuy;

    private String unit;

    private BigDecimal packageFee;

    private Integer nowStock;

    private Integer maxStock;

    private BigDecimal discountRate;

    private Integer maxDiscount;

    private BigDecimal price;

    private BigDecimal protein;

    private BigDecimal carbohydrate;

    private BigDecimal adipose;

    private BigDecimal kacl;

    private Integer weight;

    private Integer monthSell;
}
