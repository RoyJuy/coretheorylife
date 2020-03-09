package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopAccount;
import com.coretheorylife.modules.shop.entity.TShopAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopAccountMapper extends BaseMapper<TShopAccount, TShopAccountExample> {
    int countByExample(TShopAccountExample example);

    int deleteByExample(TShopAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopAccount record);

    int insertSelective(TShopAccount record);

    List<TShopAccount> selectByExample(TShopAccountExample example);

    TShopAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopAccount record, @Param("example") TShopAccountExample example);

    int updateByExample(@Param("record") TShopAccount record, @Param("example") TShopAccountExample example);

    int updateByPrimaryKeySelective(TShopAccount record);

    int updateByPrimaryKey(TShopAccount record);
}