package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsSelect;
import com.coretheorylife.modules.shop.entity.TGoodsSelectExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsSelect;

import java.util.List;

public interface TGoodsSelectService extends BaseService<TGoodsSelect, TGoodsSelectExample> {

    List<ExtTGoodsSelect> queryList(Long goodsId);
}
