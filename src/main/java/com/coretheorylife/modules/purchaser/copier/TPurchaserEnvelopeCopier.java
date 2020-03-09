package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.vo.TPurchaserEnvelopeRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserEnvelopeCopier {
    TPurchaserEnvelopeCopier INSTANCE = Mappers.getMapper(TPurchaserEnvelopeCopier.class);

    TPurchaserEnvelope asTPurchaserEnvelope(TPurchaserEnvelopeRVO bean);

    TPurchaserEnvelopeRVO asTPurchaserEnvelopeRVO(TPurchaserEnvelope bean);

    List<TPurchaserEnvelopeRVO> asTPurchaserEnvelopeRVOList(List<TPurchaserEnvelope> bean);

    TPurchaserEnvelopeRVO asTPurchaserEnvelopeRVO(ExtTPurchaserEnvelope bean);

    List<TPurchaserEnvelopeRVO> asTPurchaserEnvelopeRVOListExt(List<ExtTPurchaserEnvelope> bean);
}
