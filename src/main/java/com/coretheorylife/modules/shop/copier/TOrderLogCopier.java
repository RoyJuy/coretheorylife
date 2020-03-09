package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TOrderLog;
import com.coretheorylife.modules.shop.vo.TOrderLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TOrderLogCopier {
    TOrderLogCopier INSTANCE = Mappers.getMapper(TOrderLogCopier.class);

    List<TOrderLogRVO> asTOrderLogRVOList(List<TOrderLog> bean);

    TOrderLogRVO asTOrderLogRVO(TOrderLog bean);

}
