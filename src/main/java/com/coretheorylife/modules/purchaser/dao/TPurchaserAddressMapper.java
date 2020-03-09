package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserAddressMapper extends BaseMapper<TPurchaserAddress, TPurchaserAddressExample> {
    int countByExample(TPurchaserAddressExample example);

    int deleteByExample(TPurchaserAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserAddress record);

    int insertSelective(TPurchaserAddress record);

    List<TPurchaserAddress> selectByExample(TPurchaserAddressExample example);

    TPurchaserAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserAddress record, @Param("example") TPurchaserAddressExample example);

    int updateByExample(@Param("record") TPurchaserAddress record, @Param("example") TPurchaserAddressExample example);

    int updateByPrimaryKeySelective(TPurchaserAddress record);

    int updateByPrimaryKey(TPurchaserAddress record);
}