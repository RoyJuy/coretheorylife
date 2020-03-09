package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsLabelExample;

import java.util.List;

public interface TGoodsLabelService extends BaseService<TGoodsLabel, TGoodsLabelExample> {

    int deleteByGoodsId(Long goodsId);

    List<TGoodsLabel> queryListByGoodsId(Long goodsId);
}
