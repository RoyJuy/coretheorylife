package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserRateMapper extends BaseMapper<TPurchaserRate, TPurchaserRateExample> {
    int countByExample(TPurchaserRateExample example);

    int deleteByExample(TPurchaserRateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserRate record);

    int insertSelective(TPurchaserRate record);

    List<TPurchaserRate> selectByExample(TPurchaserRateExample example);

    TPurchaserRate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserRate record, @Param("example") TPurchaserRateExample example);

    int updateByExample(@Param("record") TPurchaserRate record, @Param("example") TPurchaserRateExample example);

    int updateByPrimaryKeySelective(TPurchaserRate record);

    int updateByPrimaryKey(TPurchaserRate record);
}