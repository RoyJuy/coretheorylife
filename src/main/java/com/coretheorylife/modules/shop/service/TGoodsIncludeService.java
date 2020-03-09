package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsInclude;
import com.coretheorylife.modules.shop.entity.TGoodsIncludeExample;

import java.util.List;

public interface TGoodsIncludeService extends BaseService<TGoodsInclude, TGoodsIncludeExample> {
    List<TGoodsInclude> queryListByGoodsId(Long goodsId);

    int deleteByGoodsId(Long goodsId);
}
