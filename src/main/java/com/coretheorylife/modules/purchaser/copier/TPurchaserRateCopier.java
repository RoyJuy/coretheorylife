package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserRateCopier {
    TPurchaserRateCopier INSTANCE = Mappers.getMapper(TPurchaserRateCopier.class);

    TPurchaserRate asTPurchaserRate(TPurchaserRateRVO bean);

    TPurchaserRateRVO asTPurchaserRateRVO(TPurchaserRate bean);

    List<TPurchaserRateRVO> asTPurchaserRateRVOList(List<TPurchaserRate> bean);

    TPurchaserRateRVO asTPurchaserRateRVOExt(ExtTPurchaserRate bean);

    List<TPurchaserRateRVO> asTPurchaserRateRVOListExt(List<ExtTPurchaserRate> bean);

    TPurchaserRate asTPurchaserRate(TPurchaserRateCVO bean);

    TPurchaserRate asTPurchaserRate(TPurchaserRateUVO bean);
}
