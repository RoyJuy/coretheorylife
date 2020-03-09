package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserHealthLogCopier {
    TPurchaserHealthLogCopier INSTANCE = Mappers.getMapper(TPurchaserHealthLogCopier.class);

    TPurchaserHealthLog asTPurchaserHealthLog(TPurchaserHealthLogRVO bean);

    TPurchaserHealthLogRVO asTPurchaserHealthLogRVO(TPurchaserHealthLog bean);

    TPurchaserHealthLogRVO asTPurchaserHealthLogRVO(ExtTPurchaserHealthLog bean);

    ExtTPurchaserHealthLog asTPurchaserHealthLog(TPurchaserHealthLog bean);

    List<TPurchaserHealthLogRVO> asTPurchaserHealthLogRVOList(List<TPurchaserHealthLog> bean);
}
