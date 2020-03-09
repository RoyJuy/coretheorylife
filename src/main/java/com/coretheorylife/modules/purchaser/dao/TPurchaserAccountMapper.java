package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccount;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserAccountMapper extends BaseMapper<TPurchaserAccount, TPurchaserAccountExample> {
    int countByExample(TPurchaserAccountExample example);

    int deleteByExample(TPurchaserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserAccount record);

    int insertSelective(TPurchaserAccount record);

    List<TPurchaserAccount> selectByExample(TPurchaserAccountExample example);

    TPurchaserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserAccount record, @Param("example") TPurchaserAccountExample example);

    int updateByExample(@Param("record") TPurchaserAccount record, @Param("example") TPurchaserAccountExample example);

    int updateByPrimaryKeySelective(TPurchaserAccount record);

    int updateByPrimaryKey(TPurchaserAccount record);
}