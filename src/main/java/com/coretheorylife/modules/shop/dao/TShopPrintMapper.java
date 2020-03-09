package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopPrint;
import com.coretheorylife.modules.shop.entity.TShopPrintExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopPrintMapper extends BaseMapper<TShopPrint, TShopPrintExample> {
    int countByExample(TShopPrintExample example);

    int deleteByExample(TShopPrintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopPrint record);

    int insertSelective(TShopPrint record);

    List<TShopPrint> selectByExample(TShopPrintExample example);

    TShopPrint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopPrint record, @Param("example") TShopPrintExample example);

    int updateByExample(@Param("record") TShopPrint record, @Param("example") TShopPrintExample example);

    int updateByPrimaryKeySelective(TShopPrint record);

    int updateByPrimaryKey(TShopPrint record);
}