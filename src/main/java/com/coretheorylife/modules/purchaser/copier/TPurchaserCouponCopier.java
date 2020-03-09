package com.coretheorylife.modules.purchaser.copier;

import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoupon;
import com.coretheorylife.modules.purchaser.vo.TPurchaserCouponRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TPurchaserCouponCopier {
    TPurchaserCouponCopier INSTANCE = Mappers.getMapper(TPurchaserCouponCopier.class);

    TPurchaserCoupon asTPurchaserCoupon(TPurchaserCouponRVO bean);

    TPurchaserCouponRVO asTPurchaserCouponRVO(TPurchaserCoupon bean);

    List<TPurchaserCouponRVO> asTPurchaserCouponRVOList(List<TPurchaserCoupon> bean);

    TPurchaserCouponRVO asTPurchaserCouponRVOExt(ExtTPurchaserCoupon bean);

    List<TPurchaserCouponRVO> asTPurchaserCouponRVOListExt(List<ExtTPurchaserCoupon> bean);
}
