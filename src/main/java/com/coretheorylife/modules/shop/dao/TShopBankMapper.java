package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopBank;
import com.coretheorylife.modules.shop.entity.TShopBankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopBankMapper extends BaseMapper<TShopBank, TShopBankExample> {
    int countByExample(TShopBankExample example);

    int deleteByExample(TShopBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopBank record);

    int insertSelective(TShopBank record);

    List<TShopBank> selectByExample(TShopBankExample example);

    TShopBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopBank record, @Param("example") TShopBankExample example);

    int updateByExample(@Param("record") TShopBank record, @Param("example") TShopBankExample example);

    int updateByPrimaryKeySelective(TShopBank record);

    int updateByPrimaryKey(TShopBank record);
}