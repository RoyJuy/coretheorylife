package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopAccountLog;
import com.coretheorylife.modules.shop.entity.TShopAccountLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopAccountLogMapper extends BaseMapper<TShopAccountLog, TShopAccountLogExample> {
    int countByExample(TShopAccountLogExample example);

    int deleteByExample(TShopAccountLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopAccountLog record);

    int insertSelective(TShopAccountLog record);

    List<TShopAccountLog> selectByExample(TShopAccountLogExample example);

    TShopAccountLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopAccountLog record, @Param("example") TShopAccountLogExample example);

    int updateByExample(@Param("record") TShopAccountLog record, @Param("example") TShopAccountLogExample example);

    int updateByPrimaryKeySelective(TShopAccountLog record);

    int updateByPrimaryKey(TShopAccountLog record);
}