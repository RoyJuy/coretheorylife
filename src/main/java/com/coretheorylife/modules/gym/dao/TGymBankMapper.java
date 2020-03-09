package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymBank;
import com.coretheorylife.modules.gym.entity.TGymBankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymBankMapper extends BaseMapper<TGymBank, TGymBankExample> {
    int countByExample(TGymBankExample example);

    int deleteByExample(TGymBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymBank record);

    int insertSelective(TGymBank record);

    List<TGymBank> selectByExample(TGymBankExample example);

    TGymBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymBank record, @Param("example") TGymBankExample example);

    int updateByExample(@Param("record") TGymBank record, @Param("example") TGymBankExample example);

    int updateByPrimaryKeySelective(TGymBank record);

    int updateByPrimaryKey(TGymBank record);
}