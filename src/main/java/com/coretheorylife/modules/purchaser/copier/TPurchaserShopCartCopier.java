package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCart;
import com.coretheorylife.modules.purchaser.vo.TPurchaserShopCartCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserShopCartUVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TPurchaserShopCartCopier {
    TPurchaserShopCartCopier INSTANCE = Mappers.getMapper(TPurchaserShopCartCopier.class);

    TPurchaserShopCart asTPurchaserShopCart(TPurchaserShopCartCVO bean);

    TPurchaserShopCart asTPurchaserShopCart(TPurchaserShopCartUVO bean);
}
