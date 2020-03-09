package com.coretheorylife.modules.sys.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.sys.entity.TUserToken;
import com.coretheorylife.modules.sys.entity.TUserTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserTokenMapper extends BaseMapper<TUserToken, TUserTokenExample> {
    int countByExample(TUserTokenExample example);

    int deleteByExample(TUserTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUserToken record);

    int insertSelective(TUserToken record);

    List<TUserToken> selectByExample(TUserTokenExample example);

    TUserToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TUserToken record, @Param("example") TUserTokenExample example);

    int updateByExample(@Param("record") TUserToken record, @Param("example") TUserTokenExample example);

    int updateByPrimaryKeySelective(TUserToken record);

    int updateByPrimaryKey(TUserToken record);
}