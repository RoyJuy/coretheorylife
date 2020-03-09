package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsSelect;

import java.util.List;

public interface ExtTGoodsSelectMapper {
    List<ExtTGoodsSelect> queryList(Long goodsId);
}
