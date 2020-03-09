package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsInclude;
import com.coretheorylife.modules.shop.entity.TGoodsIncludeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsIncludeMapper extends BaseMapper<TGoodsInclude, TGoodsIncludeExample> {
    int countByExample(TGoodsIncludeExample example);

    int deleteByExample(TGoodsIncludeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsInclude record);

    int insertSelective(TGoodsInclude record);

    List<TGoodsInclude> selectByExample(TGoodsIncludeExample example);

    TGoodsInclude selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsInclude record, @Param("example") TGoodsIncludeExample example);

    int updateByExample(@Param("record") TGoodsInclude record, @Param("example") TGoodsIncludeExample example);

    int updateByPrimaryKeySelective(TGoodsInclude record);

    int updateByPrimaryKey(TGoodsInclude record);
}