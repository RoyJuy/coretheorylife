package com.coretheorylife.modules.sys.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.sys.entity.TSysBanner;
import com.coretheorylife.modules.sys.entity.TSysBannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysBannerMapper extends BaseMapper<TSysBanner, TSysBannerExample> {
    int countByExample(TSysBannerExample example);

    int deleteByExample(TSysBannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSysBanner record);

    int insertSelective(TSysBanner record);

    List<TSysBanner> selectByExample(TSysBannerExample example);

    TSysBanner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSysBanner record, @Param("example") TSysBannerExample example);

    int updateByExample(@Param("record") TSysBanner record, @Param("example") TSysBannerExample example);

    int updateByPrimaryKeySelective(TSysBanner record);

    int updateByPrimaryKey(TSysBanner record);
}