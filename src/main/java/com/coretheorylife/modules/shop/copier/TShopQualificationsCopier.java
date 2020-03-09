package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopQualifications;
import com.coretheorylife.modules.shop.vo.TShopQualificationsRVO;
import com.coretheorylife.modules.shop.vo.TShopQualificationsUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TShopQualificationsCopier {
    TShopQualificationsCopier INSTANCE = Mappers.getMapper(TShopQualificationsCopier.class);

    TShopQualifications asTShopQualifications(TShopQualificationsRVO bean);

    TShopQualifications asTShopQualifications(TShopQualificationsUVO bean);

    TShopQualificationsRVO asTShopQualificationsRVO(TShopQualifications bean);

    List<TShopQualificationsRVO> asTShopQualificationsRVOList(List<TShopQualifications> bean);

    TShopQualificationsRVO asTShopQualificationsRVOExt(ExtTShopQualifications bean);

    List<TShopQualificationsRVO> asTShopQualificationsRVOListExt(List<ExtTShopQualifications> bean);


}
