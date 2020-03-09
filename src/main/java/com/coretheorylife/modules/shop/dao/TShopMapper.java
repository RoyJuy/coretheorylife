package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopMapper extends BaseMapper<TShop, TShopExample> {
    int countByExample(TShopExample example);

    int deleteByExample(TShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShop record);

    int insertSelective(TShop record);

    List<TShop> selectByExample(TShopExample example);

    TShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShop record, @Param("example") TShopExample example);

    int updateByExample(@Param("record") TShop record, @Param("example") TShopExample example);

    int updateByPrimaryKeySelective(TShop record);

    int updateByPrimaryKey(TShop record);
}