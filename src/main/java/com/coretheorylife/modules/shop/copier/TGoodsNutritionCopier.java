package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TGoodsNutrition;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;
import com.coretheorylife.modules.shop.vo.TGoodsNutritionCVO;
import com.coretheorylife.modules.shop.vo.TGoodsNutritionRVO;
import com.coretheorylife.modules.shop.vo.TGoodsNutritionUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsNutritionCopier {
    TGoodsNutritionCopier INSTANCE = Mappers.getMapper(TGoodsNutritionCopier.class);

    TGoodsNutrition asTGoodsNutrition(TGoodsNutritionRVO bean);

    TGoodsNutritionRVO asTGoodsNutritionRVO(TGoodsNutrition bean);

    List<TGoodsNutritionRVO> asTGoodsNutritionRVOList(List<TGoodsNutrition> bean);

    TGoodsNutritionRVO asTGoodsNutritionRVOExt(ExtTGoodsNutrition bean);

    List<TGoodsNutritionRVO> asTGoodsNutritionRVOListExt(List<ExtTGoodsNutrition> bean);

    TGoodsNutrition asTGoodsNutrition(TGoodsNutritionCVO bean);

    TGoodsNutrition asTGoodsNutrition(TGoodsNutritionUVO bean);
}
