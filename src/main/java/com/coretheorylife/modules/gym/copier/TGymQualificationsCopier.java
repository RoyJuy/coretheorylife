package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymQualifications;
import com.coretheorylife.modules.gym.vo.TGymQualificationsRVO;
import com.coretheorylife.modules.gym.vo.TGymQualificationsUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymQualificationsCopier {
    TGymQualificationsCopier INSTANCE = Mappers.getMapper(TGymQualificationsCopier.class);

    TGymQualifications asTGymQualifications(TGymQualificationsRVO bean);

    TGymQualifications asTGymQualifications(TGymQualificationsUVO bean);

    TGymQualificationsRVO asTGymQualificationsRVO(TGymQualifications bean);

    List<TGymQualificationsRVO> asTGymQualificationsRVOList(List<TGymQualifications> bean);

    TGymQualificationsRVO asTGymQualificationsRVOExt(ExtTGymQualifications bean);

    List<TGymQualificationsRVO> asTGymQualificationsRVOListExt(List<ExtTGymQualifications> bean);


}
