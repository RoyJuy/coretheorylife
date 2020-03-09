package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAccount;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAccountRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserAccountCopier {
    TPurchaserAccountCopier INSTANCE = Mappers.getMapper(TPurchaserAccountCopier.class);

    TPurchaserAccount asTPurchaserAccount(TPurchaserAccountRVO bean);

    TPurchaserAccountRVO asTPurchaserAccountRVO(TPurchaserAccount bean);

    List<TPurchaserAccountRVO> asTPurchaserAccountRVOList(List<TPurchaserAccount> bean);
}
