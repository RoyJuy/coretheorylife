package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;

import java.util.List;
import java.util.Map;

public interface ExtTGoodsNutritionMapper {
    List<ExtTGoodsNutrition> queryList(Map<String, Object> keys);

    List<ExtTGoodsNutrition> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
