package com.coretheorylife.modules.gym.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.gym.entity.TGymReservation;
import com.coretheorylife.modules.gym.entity.TGymReservationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGymReservationMapper extends BaseMapper<TGymReservation, TGymReservationExample> {
    int countByExample(TGymReservationExample example);

    int deleteByExample(TGymReservationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGymReservation record);

    int insertSelective(TGymReservation record);

    List<TGymReservation> selectByExample(TGymReservationExample example);

    TGymReservation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGymReservation record, @Param("example") TGymReservationExample example);

    int updateByExample(@Param("record") TGymReservation record, @Param("example") TGymReservationExample example);

    int updateByPrimaryKeySelective(TGymReservation record);

    int updateByPrimaryKey(TGymReservation record);
}