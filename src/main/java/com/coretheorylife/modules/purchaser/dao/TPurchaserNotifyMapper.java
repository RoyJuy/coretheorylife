package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotify;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserNotifyMapper extends BaseMapper<TPurchaserNotify, TPurchaserNotifyExample> {
    int countByExample(TPurchaserNotifyExample example);

    int deleteByExample(TPurchaserNotifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserNotify record);

    int insertSelective(TPurchaserNotify record);

    List<TPurchaserNotify> selectByExample(TPurchaserNotifyExample example);

    TPurchaserNotify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserNotify record, @Param("example") TPurchaserNotifyExample example);

    int updateByExample(@Param("record") TPurchaserNotify record, @Param("example") TPurchaserNotifyExample example);

    int updateByPrimaryKeySelective(TPurchaserNotify record);

    int updateByPrimaryKey(TPurchaserNotify record);
}