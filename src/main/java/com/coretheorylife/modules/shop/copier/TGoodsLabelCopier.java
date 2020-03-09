package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsSelect;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsLabel;
import com.coretheorylife.modules.shop.vo.TGoodsLabelCVO;
import com.coretheorylife.modules.shop.vo.TGoodsLabelRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsLabelCopier {
    TGoodsLabelCopier INSTANCE = Mappers.getMapper(TGoodsLabelCopier.class);

    TGoodsSelect asTGoodsSelects(TGoodsLabelCVO bean);

    TGoodsSelect asTGoodsSelectExt(TGoodsLabelCVO bean);

    TGoodsLabelRVO asTGoodsSelectsRVO(TGoodsLabel bean);

    List<TGoodsLabelRVO> asTGoodsSelectsRVOList(List<TGoodsLabel> bean);

    TGoodsLabelRVO asTGoodsSelectsRVOExt(ExtTGoodsLabel bean);

    List<TGoodsLabelRVO> asTGoodsSelectsRVOListExt(List<ExtTGoodsLabel> bean);
}
