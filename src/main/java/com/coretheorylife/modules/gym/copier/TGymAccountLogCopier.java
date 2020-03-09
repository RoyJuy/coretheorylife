package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGymAccountLog;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;
import com.coretheorylife.modules.gym.vo.TGymAccountLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymAccountLogCopier {
    TGymAccountLogCopier INSTANCE = Mappers.getMapper(TGymAccountLogCopier.class);

    TGymAccountLog asTGymAccountLog(TGymAccountLogRVO bean);

    TGymAccountLogRVO asTGymAccountLogRVO(TGymAccountLog bean);

    List<TGymAccountLogRVO> asTGymAccountLogRVOList(List<TGymAccountLog> bean);

    TGymAccountLogRVO asTGymAccountLogRVOExt(ExtTGymAccountLog bean);

    List<TGymAccountLogRVO> asTGymAccountLogRVOListExt(List<ExtTGymAccountLog> bean);
}
