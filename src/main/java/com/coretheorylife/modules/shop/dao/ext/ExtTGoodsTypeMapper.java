package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;

import java.util.List;
import java.util.Map;

public interface ExtTGoodsTypeMapper {
    List<ExtTGoodsType> queryList(Map<String, Object> keys);

    List<ExtTGoodsType> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    List<ExtTGoodsType> queryAllGoodByShopId(Map<String, Object> keys);
}
