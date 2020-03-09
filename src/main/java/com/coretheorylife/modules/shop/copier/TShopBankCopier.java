package com.coretheorylife.modules.shop.copier;

import com.coretheorylife.modules.shop.entity.TShopBank;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopBank;
import com.coretheorylife.modules.shop.vo.TShopBankCVO;
import com.coretheorylife.modules.shop.vo.TShopBankRVO;
import com.coretheorylife.modules.shop.vo.TShopBankUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TShopBankCopier {
    TShopBankCopier INSTANCE = Mappers.getMapper(TShopBankCopier.class);

    TShopBank asShopBank(TShopBankRVO bean);

    TShopBankRVO asTShopBankRVO(TShopBank bean);

    List<TShopBankRVO> asTShopBankRVOList(List<TShopBank> bean);

    TShopBankRVO asTShopBankRVOExt(ExtTShopBank bean);

    List<TShopBankRVO> asTShopBankRVOListExt(List<ExtTShopBank> bean);

    TShopBank asShopBank(TShopBankCVO bean);

    TShopBank asShopBank(TShopBankUVO bean);
}
