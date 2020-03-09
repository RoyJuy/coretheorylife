package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TGoodsType;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;
import com.coretheorylife.modules.shop.vo.TGoodsTypeCVO;
import com.coretheorylife.modules.shop.vo.TGoodsTypeRVO;
import com.coretheorylife.modules.shop.vo.TGoodsTypeUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsTypeCopier {
    TGoodsTypeCopier INSTANCE = Mappers.getMapper(TGoodsTypeCopier.class);

    TGoodsType asTGoodsType(TGoodsTypeRVO bean);

    TGoodsTypeRVO asTGoodsTypeRVO(TGoodsType bean);

    List<TGoodsTypeRVO> asTGoodsTypeRVOList(List<TGoodsType> bean);

    TGoodsTypeRVO asTGoodsTypeRVOExt(ExtTGoodsType bean);

    List<TGoodsTypeRVO> asTGoodsTypeRVOListExt(List<ExtTGoodsType> bean);

    TGoodsType asTGoodsType(TGoodsTypeCVO bean);

    TGoodsType asTGoodsType(TGoodsTypeUVO bean);
}
