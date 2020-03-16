package com.coretheorylife.modules.purchaser.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ShopInfo
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Data
public class ShopInfo {
    private long id;

    private String name;

    private String avatar;

    private Integer status;

    private String shopCode;

    private String address;

    private String addressDetailes;

    private BigDecimal longitude;

    private BigDecimal latitude;
}
