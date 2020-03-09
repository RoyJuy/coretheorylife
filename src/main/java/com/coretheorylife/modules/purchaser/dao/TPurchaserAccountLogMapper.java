package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserAccountLogMapper extends BaseMapper<TPurchaserAccountLog, TPurchaserAccountLogExample> {
    int countByExample(TPurchaserAccountLogExample example);

    int deleteByExample(TPurchaserAccountLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserAccountLog record);

    int insertSelective(TPurchaserAccountLog record);

    List<TPurchaserAccountLog> selectByExample(TPurchaserAccountLogExample example);

    TPurchaserAccountLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserAccountLog record, @Param("example") TPurchaserAccountLogExample example);

    int updateByExample(@Param("record") TPurchaserAccountLog record, @Param("example") TPurchaserAccountLogExample example);

    int updateByPrimaryKeySelective(TPurchaserAccountLog record);

    int updateByPrimaryKey(TPurchaserAccountLog record);
}