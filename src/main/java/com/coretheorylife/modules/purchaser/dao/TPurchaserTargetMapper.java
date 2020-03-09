package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserTargetMapper extends BaseMapper<TPurchaserTarget, TPurchaserTargetExample> {
    int countByExample(TPurchaserTargetExample example);

    int deleteByExample(TPurchaserTargetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserTarget record);

    int insertSelective(TPurchaserTarget record);

    List<TPurchaserTarget> selectByExample(TPurchaserTargetExample example);

    TPurchaserTarget selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserTarget record, @Param("example") TPurchaserTargetExample example);

    int updateByExample(@Param("record") TPurchaserTarget record, @Param("example") TPurchaserTargetExample example);

    int updateByPrimaryKeySelective(TPurchaserTarget record);

    int updateByPrimaryKey(TPurchaserTarget record);
}