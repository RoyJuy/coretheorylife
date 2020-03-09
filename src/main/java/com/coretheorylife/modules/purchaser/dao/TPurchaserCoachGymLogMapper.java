package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserCoachGymLogMapper extends BaseMapper<TPurchaserCoachGymLog, TPurchaserCoachGymLogExample> {
    int countByExample(TPurchaserCoachGymLogExample example);

    int deleteByExample(TPurchaserCoachGymLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserCoachGymLog record);

    int insertSelective(TPurchaserCoachGymLog record);

    List<TPurchaserCoachGymLog> selectByExample(TPurchaserCoachGymLogExample example);

    TPurchaserCoachGymLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserCoachGymLog record, @Param("example") TPurchaserCoachGymLogExample example);

    int updateByExample(@Param("record") TPurchaserCoachGymLog record, @Param("example") TPurchaserCoachGymLogExample example);

    int updateByPrimaryKeySelective(TPurchaserCoachGymLog record);

    int updateByPrimaryKey(TPurchaserCoachGymLog record);
}