package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserFavorite;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserFavorite;
import com.coretheorylife.modules.purchaser.vo.TPurchaserFavoriteRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserFavoriteCopier {
    TPurchaserFavoriteCopier INSTANCE = Mappers.getMapper(TPurchaserFavoriteCopier.class);

    TPurchaserFavorite asTPurchaserFavorite(TPurchaserFavoriteRVO bean);

    TPurchaserFavoriteRVO asTPurchaserFavoriteRVO(TPurchaserFavorite bean);

    List<TPurchaserFavoriteRVO> asTPurchaserFavoriteRVOList(List<TPurchaserFavorite> bean);

    TPurchaserFavoriteRVO asTPurchaserFavoriteRVOExt(ExtTPurchaserFavorite bean);

    List<TPurchaserFavoriteRVO> asTPurchaserFavoriteRVOListExt(List<ExtTPurchaserFavorite> bean);
}
