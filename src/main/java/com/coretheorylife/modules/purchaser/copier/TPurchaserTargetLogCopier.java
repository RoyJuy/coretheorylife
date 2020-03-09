package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserTargetLogCopier {
    TPurchaserTargetLogCopier INSTANCE = Mappers.getMapper(TPurchaserTargetLogCopier.class);

    TPurchaserTargetLog asTPurchaserTargetLog(TPurchaserTargetLogRVO bean);

    TPurchaserTargetLogRVO asTPurchaserTargetLogRVO(TPurchaserTargetLog bean);

    List<TPurchaserTargetLogRVO> asTPurchaserTargetLogRVOList(List<TPurchaserTargetLog> bean);

    TPurchaserTargetLogRVO asTPurchaserTargetLogRVOExt(ExtTPurchaserTargetLog bean);

    List<TPurchaserTargetLogRVO> asTPurchaserTargetLogRVOListExt(List<ExtTPurchaserTargetLog> bean);
}
