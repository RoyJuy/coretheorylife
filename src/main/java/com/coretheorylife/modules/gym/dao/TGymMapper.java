package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymMapper extends BaseMapper<TGym, TGymExample> {
    int countByExample(TGymExample example);

    int deleteByExample(TGymExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGym record);

    int insertSelective(TGym record);

    List<TGym> selectByExample(TGymExample example);

    TGym selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGym record, @Param("example") TGymExample example);

    int updateByExample(@Param("record") TGym record, @Param("example") TGymExample example);

    int updateByPrimaryKeySelective(TGym record);

    int updateByPrimaryKey(TGym record);
}