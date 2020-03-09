package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TOrderLog;
import com.coretheorylife.modules.shop.entity.TOrderLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderLogMapper extends BaseMapper<TOrderLog, TOrderLogExample> {
    int countByExample(TOrderLogExample example);

    int deleteByExample(TOrderLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderLog record);

    int insertSelective(TOrderLog record);

    List<TOrderLog> selectByExample(TOrderLogExample example);

    TOrderLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderLog record, @Param("example") TOrderLogExample example);

    int updateByExample(@Param("record") TOrderLog record, @Param("example") TOrderLogExample example);

    int updateByPrimaryKeySelective(TOrderLog record);

    int updateByPrimaryKey(TOrderLog record);
}