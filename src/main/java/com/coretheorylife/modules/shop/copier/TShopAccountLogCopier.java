package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TShopAccountLog;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;
import com.coretheorylife.modules.shop.vo.TShopAccountLogRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TShopAccountLogCopier {
    TShopAccountLogCopier INSTANCE = Mappers.getMapper(TShopAccountLogCopier.class);

    TShopAccountLog asTShopAccountLog(TShopAccountLogRVO bean);

    TShopAccountLogRVO asTShopAccountLogRVO(TShopAccountLog bean);

    List<TShopAccountLogRVO> asTShopAccountLogRVOList(List<TShopAccountLog> bean);

    TShopAccountLogRVO asTShopAccountLogRVOExt(ExtTShopAccountLog bean);

    List<TShopAccountLogRVO> asTShopAccountLogRVOListExt(List<ExtTShopAccountLog> bean);
}
