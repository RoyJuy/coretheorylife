package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAccountLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserAccountLogCopier {
    TPurchaserAccountLogCopier INSTANCE = Mappers.getMapper(TPurchaserAccountLogCopier.class);

    TPurchaserAccountLog asTPurchaserAccountLog(TPurchaserAccountLogRVO bean);

    TPurchaserAccountLogRVO asTPurchaserAccountLogRVO(TPurchaserAccountLog bean);

    List<TPurchaserAccountLogRVO> asTPurchaserAccountLogRVOList(List<TPurchaserAccountLog> bean);

    TPurchaserAccountLogRVO asTPurchaserAccountLogRVOExt(ExtTPurchaserAccountLog bean);

    List<TPurchaserAccountLogRVO> asTPurchaserAccountLogRVOListExt(List<ExtTPurchaserAccountLog> bean);
}
