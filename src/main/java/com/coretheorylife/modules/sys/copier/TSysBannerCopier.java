package com.coretheorylife.modules.sys.copier;

import com.coretheorylife.modules.sys.entity.TSysBanner;
import com.coretheorylife.modules.sys.vo.TSysBannerRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TSysBannerCopier {
    TSysBannerCopier INSTANCE = Mappers.getMapper(TSysBannerCopier.class);

    TSysBanner asSysBanner(TSysBannerRVO bean);

    TSysBannerRVO asTSysBannerRVO(TSysBanner bean);

    List<TSysBannerRVO> asTSysBannerRVOList(List<TSysBanner> bean);
}
