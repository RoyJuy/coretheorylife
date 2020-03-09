package com.coretheorylife.modules.gym.copier;

import com.coretheorylife.modules.gym.entity.TGymBank;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymBank;
import com.coretheorylife.modules.gym.vo.TGymBankCVO;
import com.coretheorylife.modules.gym.vo.TGymBankRVO;
import com.coretheorylife.modules.gym.vo.TGymBankUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TGymBankCopier {
    TGymBankCopier INSTANCE = Mappers.getMapper(TGymBankCopier.class);

    TGymBank asGymBank(TGymBankRVO bean);

    TGymBankRVO asTGymBankRVO(TGymBank bean);

    List<TGymBankRVO> asTGymBankRVOList(List<TGymBank> bean);

    TGymBankRVO asTGymBankRVOExt(ExtTGymBank bean);

    List<TGymBankRVO> asTGymBankRVOListExt(List<ExtTGymBank> bean);

    TGymBank asGymBank(TGymBankCVO bean);

    TGymBank asGymBank(TGymBankUVO bean);
}
