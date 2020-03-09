package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGymReservation;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymReservation;
import com.coretheorylife.modules.gym.vo.TGymReservationCVO;
import com.coretheorylife.modules.gym.vo.TGymReservationRVO;
import com.coretheorylife.modules.gym.vo.TGymReservationUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymReservationCopier {
    TGymReservationCopier INSTANCE = Mappers.getMapper(TGymReservationCopier.class);

    TGymReservation asGymReservation(TGymReservationRVO bean);

    TGymReservationRVO asTGymReservationRVO(TGymReservation bean);

    List<TGymReservationRVO> asTGymReservationRVOList(List<TGymReservation> bean);

    TGymReservationRVO asTGymReservationRVOExt(ExtTGymReservation bean);

    List<TGymReservationRVO> asTGymReservationRVOListExt(List<ExtTGymReservation> bean);

    TGymReservation asGymReservation(TGymReservationCVO bean);

    TGymReservation asGymReservation(TGymReservationUVO bean);
}
