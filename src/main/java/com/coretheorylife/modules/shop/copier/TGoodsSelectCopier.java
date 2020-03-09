package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TGoodsSelect;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsSelect;
import com.coretheorylife.modules.shop.vo.TGoodsSelectCVO;
import com.coretheorylife.modules.shop.vo.TGoodsSelectRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsSelectCopier {
    TGoodsSelectCopier INSTANCE = Mappers.getMapper(TGoodsSelectCopier.class);

    TGoodsSelect asTGoodsSelects(TGoodsSelectCVO bean);

    TGoodsSelectRVO asTGoodsSelectsRVO(TGoodsSelect bean);

    List<TGoodsSelectRVO> asTGoodsSelectsRVOList(List<TGoodsSelect> bean);

    TGoodsSelectRVO asTGoodsSelectsRVOExt(ExtTGoodsSelect bean);

    List<TGoodsSelectRVO> asTGoodsSelectsRVOListExt(List<ExtTGoodsSelect> bean);
}
