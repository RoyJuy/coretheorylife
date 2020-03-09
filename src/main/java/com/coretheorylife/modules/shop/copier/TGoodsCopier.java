package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.vo.TGoodsCVO;
import com.coretheorylife.modules.shop.vo.TGoodsRVO;
import com.coretheorylife.modules.shop.vo.TGoodsUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGoodsCopier {
    TGoodsCopier INSTANCE = Mappers.getMapper(TGoodsCopier.class);

    ExtTGoods asTGoods(TGoodsCVO bean);

    ExtTGoods asTGoods(TGoodsUVO bean);

    TGoodsRVO asTGoodsRVO(ExtTGoods bean);

    List<TGoodsRVO> asTGoodsRVOList(List<ExtTGoods> bean);
}
