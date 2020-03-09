package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCart;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserShopCartMapper extends BaseMapper<TPurchaserShopCart, TPurchaserShopCartExample> {
    int countByExample(TPurchaserShopCartExample example);

    int deleteByExample(TPurchaserShopCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserShopCart record);

    int insertSelective(TPurchaserShopCart record);

    List<TPurchaserShopCart> selectByExample(TPurchaserShopCartExample example);

    TPurchaserShopCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserShopCart record, @Param("example") TPurchaserShopCartExample example);

    int updateByExample(@Param("record") TPurchaserShopCart record, @Param("example") TPurchaserShopCartExample example);

    int updateByPrimaryKeySelective(TPurchaserShopCart record);

    int updateByPrimaryKey(TPurchaserShopCart record);
}