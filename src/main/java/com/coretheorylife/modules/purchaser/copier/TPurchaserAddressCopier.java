package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAddress;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserAddressCopier {
    TPurchaserAddressCopier INSTANCE = Mappers.getMapper(TPurchaserAddressCopier.class);

    TPurchaserAddress asTPurchaserAddress(TPurchaserAddressRVO bean);

    TPurchaserAddressRVO asTPurchaserAddressRVO(TPurchaserAddress bean);

    List<TPurchaserAddressRVO> asTPurchaserAddressRVOList(List<TPurchaserAddress> bean);

    TPurchaserAddressRVO asTPurchaserAddressRVOExt(ExtTPurchaserAddress bean);

    List<TPurchaserAddressRVO> asTPurchaserAddressRVOListExt(List<ExtTPurchaserAddress> bean);

    TPurchaserAddress asTPurchaserAddress(TPurchaserAddressCVO bean);

    TPurchaserAddress asTPurchaserAddress(TPurchaserAddressUVO bean);
}
