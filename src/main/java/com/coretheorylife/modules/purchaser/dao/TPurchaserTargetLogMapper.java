package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserTargetLogMapper extends BaseMapper<TPurchaserTargetLog, TPurchaserTargetLogExample> {
    int countByExample(TPurchaserTargetLogExample example);

    int deleteByExample(TPurchaserTargetLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserTargetLog record);

    int insertSelective(TPurchaserTargetLog record);

    List<TPurchaserTargetLog> selectByExample(TPurchaserTargetLogExample example);

    TPurchaserTargetLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserTargetLog record, @Param("example") TPurchaserTargetLogExample example);

    int updateByExample(@Param("record") TPurchaserTargetLog record, @Param("example") TPurchaserTargetLogExample example);

    int updateByPrimaryKeySelective(TPurchaserTargetLog record);

    int updateByPrimaryKey(TPurchaserTargetLog record);
}