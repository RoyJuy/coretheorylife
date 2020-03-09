package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.entity.TShopTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopTokenMapper extends BaseMapper<TShopToken, TShopTokenExample> {
    int countByExample(TShopTokenExample example);

    int deleteByExample(TShopTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopToken record);

    int insertSelective(TShopToken record);

    List<TShopToken> selectByExample(TShopTokenExample example);

    TShopToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopToken record, @Param("example") TShopTokenExample example);

    int updateByExample(@Param("record") TShopToken record, @Param("example") TShopTokenExample example);

    int updateByPrimaryKeySelective(TShopToken record);

    int updateByPrimaryKey(TShopToken record);
}