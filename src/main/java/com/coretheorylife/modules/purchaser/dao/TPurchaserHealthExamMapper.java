package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserHealthExamMapper extends BaseMapper<TPurchaserHealthExam, TPurchaserHealthExamExample> {
    int countByExample(TPurchaserHealthExamExample example);

    int deleteByExample(TPurchaserHealthExamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserHealthExam record);

    int insertSelective(TPurchaserHealthExam record);

    List<TPurchaserHealthExam> selectByExample(TPurchaserHealthExamExample example);

    TPurchaserHealthExam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserHealthExam record, @Param("example") TPurchaserHealthExamExample example);

    int updateByExample(@Param("record") TPurchaserHealthExam record, @Param("example") TPurchaserHealthExamExample example);

    int updateByPrimaryKeySelective(TPurchaserHealthExam record);

    int updateByPrimaryKey(TPurchaserHealthExam record);
}