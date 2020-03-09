package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.TGoods;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;

import java.util.List;
import java.util.Map;

public interface ExtTGoodsMapper {
    int insertSelective(TGoods record);

    int subStock(ExtTGoods tGoods);

    int returnStock(ExtTGoods tGoods);

    List<ExtTGoods> selectGoodByShopIdOrGoodsName(Map<String, Object> map);
}
