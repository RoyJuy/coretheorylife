package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.entity.TGymCoachExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymCoachMapper extends BaseMapper<TGymCoach, TGymCoachExample> {
    int countByExample(TGymCoachExample example);

    int deleteByExample(TGymCoachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymCoach record);

    int insertSelective(TGymCoach record);

    List<TGymCoach> selectByExample(TGymCoachExample example);

    TGymCoach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymCoach record, @Param("example") TGymCoachExample example);

    int updateByExample(@Param("record") TGymCoach record, @Param("example") TGymCoachExample example);

    int updateByPrimaryKeySelective(TGymCoach record);

    int updateByPrimaryKey(TGymCoach record);
}