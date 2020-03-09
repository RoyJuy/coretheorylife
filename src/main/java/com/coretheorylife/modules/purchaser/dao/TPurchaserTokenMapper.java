package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserToken;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserTokenMapper extends BaseMapper<TPurchaserToken, TPurchaserTokenExample> {
    int countByExample(TPurchaserTokenExample example);

    int deleteByExample(TPurchaserTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserToken record);

    int insertSelective(TPurchaserToken record);

    List<TPurchaserToken> selectByExample(TPurchaserTokenExample example);

    TPurchaserToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserToken record, @Param("example") TPurchaserTokenExample example);

    int updateByExample(@Param("record") TPurchaserToken record, @Param("example") TPurchaserTokenExample example);

    int updateByPrimaryKeySelective(TPurchaserToken record);

    int updateByPrimaryKey(TPurchaserToken record);
}