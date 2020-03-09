package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.gym.entity.ext.ExtTGymReservation;

import java.util.List;
import java.util.Map;

public interface ExtTGymReservationMapper {
    List<ExtTGymReservation> queryList(Map<String, Object> keys);

    int queryTotal(Map<String, Object> keys);
}
