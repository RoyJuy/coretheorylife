package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymAccountLog;
import com.coretheorylife.modules.gym.entity.TGymAccountLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymAccountLogMapper extends BaseMapper<TGymAccountLog, TGymAccountLogExample> {
    int countByExample(TGymAccountLogExample example);

    int deleteByExample(TGymAccountLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymAccountLog record);

    int insertSelective(TGymAccountLog record);

    List<TGymAccountLog> selectByExample(TGymAccountLogExample example);

    TGymAccountLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymAccountLog record, @Param("example") TGymAccountLogExample example);

    int updateByExample(@Param("record") TGymAccountLog record, @Param("example") TGymAccountLogExample example);

    int updateByPrimaryKeySelective(TGymAccountLog record);

    int updateByPrimaryKey(TGymAccountLog record);
}