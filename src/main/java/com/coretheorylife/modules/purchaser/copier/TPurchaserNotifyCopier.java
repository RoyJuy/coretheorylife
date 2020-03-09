package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserNotify;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;
import com.coretheorylife.modules.purchaser.vo.TPurchaserNotifyRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserNotifyCopier {
    TPurchaserNotifyCopier INSTANCE = Mappers.getMapper(TPurchaserNotifyCopier.class);

    TPurchaserNotify asTPurchaserNotify(TPurchaserNotifyRVO bean);

    TPurchaserNotifyRVO asTPurchaserNotifyRVO(TPurchaserNotify bean);

    List<TPurchaserNotifyRVO> asTPurchaserNotifyRVOList(List<TPurchaserNotify> bean);

    TPurchaserNotifyRVO asTPurchaserNotifyRVOExt(ExtTPurchaserNotify bean);

    List<TPurchaserNotifyRVO> asTPurchaserNotifyRVOListExt(List<ExtTPurchaserNotify> bean);
}
