package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TOrderLine;
import com.coretheorylife.modules.shop.entity.TOrderLineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderLineMapper extends BaseMapper<TOrderLine, TOrderLineExample> {
    int countByExample(TOrderLineExample example);

    int deleteByExample(TOrderLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderLine record);

    int insertSelective(TOrderLine record);

    List<TOrderLine> selectByExample(TOrderLineExample example);

    TOrderLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderLine record, @Param("example") TOrderLineExample example);

    int updateByExample(@Param("record") TOrderLine record, @Param("example") TOrderLineExample example);

    int updateByPrimaryKeySelective(TOrderLine record);

    int updateByPrimaryKey(TOrderLine record);
}