package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsLog;
import com.coretheorylife.modules.shop.entity.TGoodsLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsLogMapper extends BaseMapper<TGoodsLog, TGoodsLogExample> {
    int countByExample(TGoodsLogExample example);

    int deleteByExample(TGoodsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsLog record);

    int insertSelective(TGoodsLog record);

    List<TGoodsLog> selectByExample(TGoodsLogExample example);

    TGoodsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsLog record, @Param("example") TGoodsLogExample example);

    int updateByExample(@Param("record") TGoodsLog record, @Param("example") TGoodsLogExample example);

    int updateByPrimaryKeySelective(TGoodsLog record);

    int updateByPrimaryKey(TGoodsLog record);
}