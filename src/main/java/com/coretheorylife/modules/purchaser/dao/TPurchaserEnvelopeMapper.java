package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelopeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserEnvelopeMapper extends BaseMapper<TPurchaserEnvelope, TPurchaserEnvelopeExample> {
    int countByExample(TPurchaserEnvelopeExample example);

    int deleteByExample(TPurchaserEnvelopeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserEnvelope record);

    int insertSelective(TPurchaserEnvelope record);

    List<TPurchaserEnvelope> selectByExample(TPurchaserEnvelopeExample example);

    TPurchaserEnvelope selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserEnvelope record, @Param("example") TPurchaserEnvelopeExample example);

    int updateByExample(@Param("record") TPurchaserEnvelope record, @Param("example") TPurchaserEnvelopeExample example);

    int updateByPrimaryKeySelective(TPurchaserEnvelope record);

    int updateByPrimaryKey(TPurchaserEnvelope record);
}