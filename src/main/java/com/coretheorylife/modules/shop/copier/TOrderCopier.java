package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;
import com.coretheorylife.modules.shop.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TOrderCopier {
    TOrderCopier INSTANCE = Mappers.getMapper(TOrderCopier.class);

    ExtTOrder asTOrder(TOrderCVO bean);

    TOrderRVO asTOrderRVO(TOrder bean);

    List<TOrderRVO> asTOrderRVOList(List<TOrder> bean);

    TOrderRVO asTOrderRVOExt(ExtTOrder bean);

    List<TOrderRVO> asTOrderRVOListExt(List<ExtTOrder> bean);
}
