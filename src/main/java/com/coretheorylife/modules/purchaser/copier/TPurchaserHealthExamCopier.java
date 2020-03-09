package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthExamCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthExamRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthExamUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserHealthExamCopier {
    TPurchaserHealthExamCopier INSTANCE = Mappers.getMapper(TPurchaserHealthExamCopier.class);

    TPurchaserHealthExam asTPurchaserHealthExam(TPurchaserHealthExamRVO bean);

    TPurchaserHealthExamRVO asTPurchaserHealthExamRVO(TPurchaserHealthExam bean);

    List<TPurchaserHealthExamRVO> asTPurchaserHealthExamRVOList(List<TPurchaserHealthExam> bean);

    TPurchaserHealthExam asTPurchaserHealthExam(TPurchaserHealthExamCVO bean);

    TPurchaserHealthExam asTPurchaserHealthExam(TPurchaserHealthExamUVO bean);
}
