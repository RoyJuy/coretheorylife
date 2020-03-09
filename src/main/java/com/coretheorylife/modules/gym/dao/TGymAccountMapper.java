package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymAccount;
import com.coretheorylife.modules.gym.entity.TGymAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymAccountMapper extends BaseMapper<TGymAccount, TGymAccountExample> {
    int countByExample(TGymAccountExample example);

    int deleteByExample(TGymAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymAccount record);

    int insertSelective(TGymAccount record);

    List<TGymAccount> selectByExample(TGymAccountExample example);

    TGymAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymAccount record, @Param("example") TGymAccountExample example);

    int updateByExample(@Param("record") TGymAccount record, @Param("example") TGymAccountExample example);

    int updateByPrimaryKeySelective(TGymAccount record);

    int updateByPrimaryKey(TGymAccount record);
}