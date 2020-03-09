package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.TShopQualificationsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopQualificationsMapper extends BaseMapper<TShopQualifications, TShopQualificationsExample> {
    int countByExample(TShopQualificationsExample example);

    int deleteByExample(TShopQualificationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopQualifications record);

    int insertSelective(TShopQualifications record);

    List<TShopQualifications> selectByExample(TShopQualificationsExample example);

    TShopQualifications selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopQualifications record, @Param("example") TShopQualificationsExample example);

    int updateByExample(@Param("record") TShopQualifications record, @Param("example") TShopQualificationsExample example);

    int updateByPrimaryKeySelective(TShopQualifications record);

    int updateByPrimaryKey(TShopQualifications record);
}