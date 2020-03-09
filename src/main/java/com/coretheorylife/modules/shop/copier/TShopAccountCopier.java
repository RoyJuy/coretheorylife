package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TShopAccount;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccount;
import com.coretheorylife.modules.shop.vo.TShopAccountRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TShopAccountCopier {
    TShopAccountCopier INSTANCE = Mappers.getMapper(TShopAccountCopier.class);

    TShopAccount asTShopAccount(TShopAccountRVO bean);

    TShopAccountRVO asTShopAccountRVO(TShopAccount bean);

    List<TShopAccountRVO> asTShopAccountRVOList(List<TShopAccount> bean);

    TShopAccountRVO asTShopAccountRVOExt(ExtTShopAccount bean);

    List<TShopAccountRVO> asTShopAccountRVOListExt(List<ExtTShopAccount> bean);
}
