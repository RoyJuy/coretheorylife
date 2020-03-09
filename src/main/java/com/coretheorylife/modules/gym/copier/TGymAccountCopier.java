package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGymAccount;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccount;
import com.coretheorylife.modules.gym.vo.TGymAccountRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymAccountCopier {
    TGymAccountCopier INSTANCE = Mappers.getMapper(TGymAccountCopier.class);

    TGymAccount asTGymAccount(TGymAccountRVO bean);

    TGymAccountRVO asTGymAccountRVO(TGymAccount bean);

    List<TGymAccountRVO> asTGymAccountRVOList(List<TGymAccount> bean);

    TGymAccountRVO asTGymAccountRVOExt(ExtTGymAccount bean);

    List<TGymAccountRVO> asTGymAccountRVOListExt(List<ExtTGymAccount> bean);
}
