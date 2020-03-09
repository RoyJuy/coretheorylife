package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.ext.ExtTGym;
import com.coretheorylife.modules.gym.vo.TGymRVO;
import com.coretheorylife.modules.gym.vo.TGymReSetAccountPasswordVO;
import com.coretheorylife.modules.gym.vo.TGymReSetPasswordVO;
import com.coretheorylife.modules.gym.vo.TGymUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymCopier {
    TGymCopier INSTANCE = Mappers.getMapper(TGymCopier.class);

    TGym asTGym(TGymRVO bean);

    TGymRVO asTGymRVO(TGym bean);

    List<TGymRVO> asTGymRVOList(List<TGym> bean);

    TGymRVO asTGymRVOExt(ExtTGym bean);

    List<TGymRVO> asTGymRVOListExt(List<ExtTGym> bean);

    TGym asTGym(TGymUVO bean);

    TGym asTGym(TGymReSetPasswordVO bean);

    TGym asTGym(TGymReSetAccountPasswordVO bean);
}
