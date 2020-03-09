package com.coretheorylife.modules.sys.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper extends BaseMapper<TUser, TUserExample> {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}