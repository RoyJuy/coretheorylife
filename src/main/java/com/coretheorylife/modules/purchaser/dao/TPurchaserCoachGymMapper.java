package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGym;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserCoachGymMapper extends BaseMapper<TPurchaserCoachGym, TPurchaserCoachGymExample> {
    int countByExample(TPurchaserCoachGymExample example);

    int deleteByExample(TPurchaserCoachGymExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserCoachGym record);

    int insertSelective(TPurchaserCoachGym record);

    List<TPurchaserCoachGym> selectByExample(TPurchaserCoachGymExample example);

    TPurchaserCoachGym selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserCoachGym record, @Param("example") TPurchaserCoachGymExample example);

    int updateByExample(@Param("record") TPurchaserCoachGym record, @Param("example") TPurchaserCoachGymExample example);

    int updateByPrimaryKeySelective(TPurchaserCoachGym record);

    int updateByPrimaryKey(TPurchaserCoachGym record);
}