package com.coretheorylife.modules.purchaser.common.vo;

import com.coretheorylife.modules.purchaser.common.GoodsInfo;
import com.coretheorylife.modules.purchaser.common.ShopCartInfo;
import com.coretheorylife.modules.purchaser.common.ShopInfo;
import lombok.Data;

import java.util.List;

/**
 * ShopCartVo
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Data
public class ShopCartVo extends ShopCartInfo {
    private List<GoodsInfo> goodsInfos;

    private ShopInfo shopInfo;
}
