package com.coretheorylife.modules.shop.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.shop.entity.TShopShipLog;
import com.coretheorylife.modules.shop.entity.TShopShipLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShopShipLogMapper extends BaseMapper<TShopShipLog, TShopShipLogExample> {
    int countByExample(TShopShipLogExample example);

    int deleteByExample(TShopShipLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TShopShipLog record);

    int insertSelective(TShopShipLog record);

    List<TShopShipLog> selectByExample(TShopShipLogExample example);

    TShopShipLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TShopShipLog record, @Param("example") TShopShipLogExample example);

    int updateByExample(@Param("record") TShopShipLog record, @Param("example") TShopShipLogExample example);

    int updateByPrimaryKeySelective(TShopShipLog record);

    int updateByPrimaryKey(TShopShipLog record);
}