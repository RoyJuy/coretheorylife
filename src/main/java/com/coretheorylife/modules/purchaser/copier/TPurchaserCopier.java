package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserReSetAccountPasswordVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserReSetPasswordVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserCopier {
    TPurchaserCopier INSTANCE = Mappers.getMapper(TPurchaserCopier.class);

    TPurchaser asTPurchaser(TPurchaserRVO bean);

    ExtTPurchaser asTPurchaserExt(TPurchaser bean);

    TPurchaserRVO asTPurchaserRVO(TPurchaser bean);

    List<TPurchaserRVO> asTPurchaserRVOList(List<TPurchaser> bean);

    TPurchaserRVO asTPurchaserRVOExt(ExtTPurchaser bean);

    List<TPurchaserRVO> asTPurchaserRVOListExt(List<ExtTPurchaser> bean);

    TPurchaser asTPurchaser(TPurchaserUVO bean);

    TPurchaser asTPurchaser(TPurchaserReSetPasswordVO bean);

    TPurchaser asTPurchaser(TPurchaserReSetAccountPasswordVO bean);
}
