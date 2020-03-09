package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsInclude;
import com.coretheorylife.modules.shop.vo.TGoodsIncludeCVO;
import com.coretheorylife.modules.shop.vo.TGoodsIncludeCVOForSaveGoods;
import com.coretheorylife.modules.shop.vo.TGoodsIncludeUVOForUpdateGoods;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsIncludeCopier {
    TGoodsIncludeCopier INSTANCE = Mappers.getMapper(TGoodsIncludeCopier.class);

    ExtTGoodsInclude asTGoodsInclude(TGoodsIncludeCVO bean);

    List<ExtTGoodsInclude> asTGoodsIncludeListExt(List<TGoodsIncludeCVO> list);

    ExtTGoodsInclude asTGoodsInclude(TGoodsIncludeCVOForSaveGoods bean);

    List<ExtTGoodsInclude> asTGoodsIncludeListExtForSaveGoods(List<TGoodsIncludeCVOForSaveGoods> list);

    ExtTGoodsInclude asTGoodsInclude(TGoodsIncludeUVOForUpdateGoods bean);

    List<ExtTGoodsInclude> asTGoodsIncludeListExtForUpdateGood(List<TGoodsIncludeUVOForUpdateGoods> list);

}
