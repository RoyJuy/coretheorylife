package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsType;
import com.coretheorylife.modules.shop.entity.TGoodsTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsTypeMapper extends BaseMapper<TGoodsType, TGoodsTypeExample> {
    int countByExample(TGoodsTypeExample example);

    int deleteByExample(TGoodsTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsType record);

    int insertSelective(TGoodsType record);

    List<TGoodsType> selectByExample(TGoodsTypeExample example);

    TGoodsType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsType record, @Param("example") TGoodsTypeExample example);

    int updateByExample(@Param("record") TGoodsType record, @Param("example") TGoodsTypeExample example);

    int updateByPrimaryKeySelective(TGoodsType record);

    int updateByPrimaryKey(TGoodsType record);
}