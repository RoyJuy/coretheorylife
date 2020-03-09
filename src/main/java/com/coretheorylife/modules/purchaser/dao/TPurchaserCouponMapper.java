package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCouponExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserCouponMapper extends BaseMapper<TPurchaserCoupon, TPurchaserCouponExample> {
    int countByExample(TPurchaserCouponExample example);

    int deleteByExample(TPurchaserCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserCoupon record);

    int insertSelective(TPurchaserCoupon record);

    List<TPurchaserCoupon> selectByExample(TPurchaserCouponExample example);

    TPurchaserCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserCoupon record, @Param("example") TPurchaserCouponExample example);

    int updateByExample(@Param("record") TPurchaserCoupon record, @Param("example") TPurchaserCouponExample example);

    int updateByPrimaryKeySelective(TPurchaserCoupon record);

    int updateByPrimaryKey(TPurchaserCoupon record);
}