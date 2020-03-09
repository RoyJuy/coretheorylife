package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTarget;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserTargetCopier {
    TPurchaserTargetCopier INSTANCE = Mappers.getMapper(TPurchaserTargetCopier.class);

    TPurchaserTarget asTPurchaserTarget(TPurchaserTargetRVO bean);

    TPurchaserTargetRVO asTPurchaserTargetRVO(TPurchaserTarget bean);

    List<TPurchaserTargetRVO> asTPurchaserTargetRVOList(List<TPurchaserTarget> bean);

    TPurchaserTargetRVO asTPurchaserTargetRVOExt(ExtTPurchaserTarget bean);

    List<TPurchaserTargetRVO> asTPurchaserTargetRVOListExt(List<ExtTPurchaserTarget> bean);

    TPurchaserTarget asTPurchaserTarget(TPurchaserTargetCVO bean);

    TPurchaserTarget asTPurchaserTarget(TPurchaserTargetUVO bean);
}
