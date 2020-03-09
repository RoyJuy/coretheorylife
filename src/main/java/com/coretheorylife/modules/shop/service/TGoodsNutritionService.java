package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsNutrition;
import com.coretheorylife.modules.shop.entity.TGoodsNutritionExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;

import java.util.List;
import java.util.Map;

public interface TGoodsNutritionService  extends BaseService<TGoodsNutrition, TGoodsNutritionExample> {
    List<ExtTGoodsNutrition> queryList(Map<String, Object> keys);

    List<ExtTGoodsNutrition> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
