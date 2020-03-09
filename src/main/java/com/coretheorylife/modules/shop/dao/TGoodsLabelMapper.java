package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsLabelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsLabelMapper extends BaseMapper<TGoodsLabel, TGoodsLabelExample> {
    int countByExample(TGoodsLabelExample example);

    int deleteByExample(TGoodsLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGoodsLabel record);

    int insertSelective(TGoodsLabel record);

    List<TGoodsLabel> selectByExample(TGoodsLabelExample example);

    TGoodsLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGoodsLabel record, @Param("example") TGoodsLabelExample example);

    int updateByExample(@Param("record") TGoodsLabel record, @Param("example") TGoodsLabelExample example);

    int updateByPrimaryKeySelective(TGoodsLabel record);

    int updateByPrimaryKey(TGoodsLabel record);
}