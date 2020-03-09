package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserBankMapper extends BaseMapper<TPurchaserBank, TPurchaserBankExample> {
    int countByExample(TPurchaserBankExample example);

    int deleteByExample(TPurchaserBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserBank record);

    int insertSelective(TPurchaserBank record);

    List<TPurchaserBank> selectByExample(TPurchaserBankExample example);

    TPurchaserBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserBank record, @Param("example") TPurchaserBankExample example);

    int updateByExample(@Param("record") TPurchaserBank record, @Param("example") TPurchaserBankExample example);

    int updateByPrimaryKeySelective(TPurchaserBank record);

    int updateByPrimaryKey(TPurchaserBank record);
}