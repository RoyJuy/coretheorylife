package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsSelect;
import com.coretheorylife.modules.shop.entity.TGoodsSelectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsSelectMapper extends BaseMapper<TGoodsSelect, TGoodsSelectExample> {
    int countByExample(TGoodsSelectExample example);

    int deleteByExample(TGoodsSelectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsSelect record);

    int insertSelective(TGoodsSelect record);

    List<TGoodsSelect> selectByExample(TGoodsSelectExample example);

    TGoodsSelect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsSelect record, @Param("example") TGoodsSelectExample example);

    int updateByExample(@Param("record") TGoodsSelect record, @Param("example") TGoodsSelectExample example);

    int updateByPrimaryKeySelective(TGoodsSelect record);

    int updateByPrimaryKey(TGoodsSelect record);
}