package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsNutrition;
import com.coretheorylife.modules.shop.entity.TGoodsNutritionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsNutritionMapper extends BaseMapper<TGoodsNutrition, TGoodsNutritionExample> {
    int countByExample(TGoodsNutritionExample example);

    int deleteByExample(TGoodsNutritionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsNutrition record);

    int insertSelective(TGoodsNutrition record);

    List<TGoodsNutrition> selectByExample(TGoodsNutritionExample example);

    TGoodsNutrition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsNutrition record, @Param("example") TGoodsNutritionExample example);

    int updateByExample(@Param("record") TGoodsNutrition record, @Param("example") TGoodsNutritionExample example);

    int updateByPrimaryKeySelective(TGoodsNutrition record);

    int updateByPrimaryKey(TGoodsNutrition record);
}