package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserHealthMapper extends BaseMapper<TPurchaserHealth, TPurchaserHealthExample> {
    int countByExample(TPurchaserHealthExample example);

    int deleteByExample(TPurchaserHealthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserHealth record);

    int insertSelective(TPurchaserHealth record);

    List<TPurchaserHealth> selectByExample(TPurchaserHealthExample example);

    TPurchaserHealth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserHealth record, @Param("example") TPurchaserHealthExample example);

    int updateByExample(@Param("record") TPurchaserHealth record, @Param("example") TPurchaserHealthExample example);

    int updateByPrimaryKeySelective(TPurchaserHealth record);

    int updateByPrimaryKey(TPurchaserHealth record);
}