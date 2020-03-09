package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserBank;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserBankCopier {
    TPurchaserBankCopier INSTANCE = Mappers.getMapper(TPurchaserBankCopier.class);

    TPurchaserBank asTPurchaserBank(TPurchaserBankRVO bean);

    TPurchaserBankRVO asTPurchaserBankRVO(TPurchaserBank bean);

    List<TPurchaserBankRVO> asTPurchaserBankRVOList(List<TPurchaserBank> bean);

    TPurchaserBankRVO asTPurchaserBankRVOExt(ExtTPurchaserBank bean);

    List<TPurchaserBankRVO> asTPurchaserBankRVOListExt(List<ExtTPurchaserBank> bean);

    TPurchaserBank asTPurchaserBank(TPurchaserBankCVO bean);

    TPurchaserBank asTPurchaserBank(TPurchaserBankUVO bean);
}
