package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopPic;
import com.coretheorylife.modules.shop.entity.TShopPicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopPicMapper extends BaseMapper<TShopPic, TShopPicExample> {
    int countByExample(TShopPicExample example);

    int deleteByExample(TShopPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopPic record);

    int insertSelective(TShopPic record);

    List<TShopPic> selectByExample(TShopPicExample example);

    TShopPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopPic record, @Param("example") TShopPicExample example);

    int updateByExample(@Param("record") TShopPic record, @Param("example") TShopPicExample example);

    int updateByPrimaryKeySelective(TShopPic record);

    int updateByPrimaryKey(TShopPic record);
}