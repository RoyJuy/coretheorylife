package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.TGymQualificationsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymQualificationsMapper extends BaseMapper<TGymQualifications, TGymQualificationsExample> {
    int countByExample(TGymQualificationsExample example);

    int deleteByExample(TGymQualificationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymQualifications record);

    int insertSelective(TGymQualifications record);

    List<TGymQualifications> selectByExample(TGymQualificationsExample example);

    TGymQualifications selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymQualifications record, @Param("example") TGymQualificationsExample example);

    int updateByExample(@Param("record") TGymQualifications record, @Param("example") TGymQualificationsExample example);

    int updateByPrimaryKeySelective(TGymQualifications record);

    int updateByPrimaryKey(TGymQualifications record);
}