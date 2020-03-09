package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsType;
import com.coretheorylife.modules.shop.entity.TGoodsTypeExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;

import java.util.List;
import java.util.Map;

public interface TGoodsTypeService extends BaseService<TGoodsType, TGoodsTypeExample> {
    List<ExtTGoodsType> queryList(Map<String, Object> keys);

    List<ExtTGoodsType> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    List<ExtTGoodsType> queryAllGoodByShopId(Map<String, Object> keys);
}
