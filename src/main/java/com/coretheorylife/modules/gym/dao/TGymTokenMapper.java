package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymToken;
import com.coretheorylife.modules.gym.entity.TGymTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymTokenMapper extends BaseMapper<TGymToken, TGymTokenExample> {
    int countByExample(TGymTokenExample example);

    int deleteByExample(TGymTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymToken record);

    int insertSelective(TGymToken record);

    List<TGymToken> selectByExample(TGymTokenExample example);

    TGymToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymToken record, @Param("example") TGymTokenExample example);

    int updateByExample(@Param("record") TGymToken record, @Param("example") TGymTokenExample example);

    int updateByPrimaryKeySelective(TGymToken record);

    int updateByPrimaryKey(TGymToken record);
}