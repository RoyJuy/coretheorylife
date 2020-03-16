package com.coretheorylife.modules.purchaser.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * ShopCartInfo
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Data
public class ShopCartInfo {
    private long id;

    @JsonIgnore
    private long goodsId;

    private Integer number;

}
