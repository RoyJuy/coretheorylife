package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserHealthCopier {
    TPurchaserHealthCopier INSTANCE = Mappers.getMapper(TPurchaserHealthCopier.class);

    TPurchaserHealth asTPurchaserHealth(TPurchaserHealthRVO bean);

    TPurchaserHealthRVO asTPurchaserHealthRVO(TPurchaserHealth bean);

    List<TPurchaserHealthRVO> asTPurchaserHealthRVOList(List<TPurchaserHealth> bean);

    TPurchaserHealthRVO asTPurchaserHealthRVOExt(ExtTPurchaserHealth bean);

    List<TPurchaserHealthRVO> asTPurchaserHealthRVOListExt(List<ExtTPurchaserHealth> bean);

    TPurchaserHealth asTPurchaserHealth(TPurchaserHealthCVO bean);

    ExtTPurchaserHealth asTPurchaserHealthExt(TPurchaserHealthCVO bean);

    TPurchaserHealth asTPurchaserHealth(TPurchaserHealthUVO bean);
}
