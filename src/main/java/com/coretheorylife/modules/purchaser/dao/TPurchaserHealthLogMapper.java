package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserHealthLogMapper extends BaseMapper<TPurchaserHealthLog, TPurchaserHealthLogExample> {
    int countByExample(TPurchaserHealthLogExample example);

    int deleteByExample(TPurchaserHealthLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserHealthLog record);

    int insertSelective(TPurchaserHealthLog record);

    List<TPurchaserHealthLog> selectByExample(TPurchaserHealthLogExample example);

    TPurchaserHealthLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserHealthLog record, @Param("example") TPurchaserHealthLogExample example);

    int updateByExample(@Param("record") TPurchaserHealthLog record, @Param("example") TPurchaserHealthLogExample example);

    int updateByPrimaryKeySelective(TPurchaserHealthLog record);

    int updateByPrimaryKey(TPurchaserHealthLog record);
}