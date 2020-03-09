package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserMapper extends BaseMapper<TPurchaser, TPurchaserExample> {
    int countByExample(TPurchaserExample example);

    int deleteByExample(TPurchaserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaser record);

    int insertSelective(TPurchaser record);

    List<TPurchaser> selectByExample(TPurchaserExample example);

    TPurchaser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaser record, @Param("example") TPurchaserExample example);

    int updateByExample(@Param("record") TPurchaser record, @Param("example") TPurchaserExample example);

    int updateByPrimaryKeySelective(TPurchaser record);

    int updateByPrimaryKey(TPurchaser record);
}