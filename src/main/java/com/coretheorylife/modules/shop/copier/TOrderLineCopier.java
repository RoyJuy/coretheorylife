package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TOrderLine;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrderLine;
import com.coretheorylife.modules.shop.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TOrderLineCopier {
    TOrderLineCopier INSTANCE = Mappers.getMapper(TOrderLineCopier.class);

    TOrderLine asTOrderLine(TOrderLineRVO bean);

    TOrderLineRVO asTOrderLineRVO(TOrderLine bean);

    List<TOrderLineRVO> asTOrderLineRVOList(List<TOrderLine> bean);

    TOrderLineRVO asTOrderLineRVOExt(ExtTOrderLine bean);

    List<TOrderLineRVO> asTOrderLineRVOListExt(List<ExtTOrderLine> bean);
}
