package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TShopCopier {
    TShopCopier INSTANCE = Mappers.getMapper(TShopCopier.class);

    TShop asTShop(TShopRVO bean);

    TShopRVO asTShopRVO(TShop bean);

    List<TShopRVO> asTShopRVOList(List<TShop> bean);

    TShopRVO asTShopRVOExt(ExtTShop bean);

    List<TShopRVO> asTShopRVOListExt(List<ExtTShop> bean);

    TShop asTShop(TShopUVO bean);

    TShop asTShop(TShopReSetPasswordVO bean);

    TShop asTShop(TShopReSetAccountPasswordVO bean);
}
