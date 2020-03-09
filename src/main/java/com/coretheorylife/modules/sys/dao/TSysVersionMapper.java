package com.coretheorylife.modules.sys.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.sys.entity.TSysVersion;
import com.coretheorylife.modules.sys.entity.TSysVersionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysVersionMapper extends BaseMapper<TSysVersion, TSysVersionExample> {
    int countByExample(TSysVersionExample example);

    int deleteByExample(TSysVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSysVersion record);

    int insertSelective(TSysVersion record);

    List<TSysVersion> selectByExample(TSysVersionExample example);

    TSysVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSysVersion record, @Param("example") TSysVersionExample example);

    int updateByExample(@Param("record") TSysVersion record, @Param("example") TSysVersionExample example);

    int updateByPrimaryKeySelective(TSysVersion record);

    int updateByPrimaryKey(TSysVersion record);
}