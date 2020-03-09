package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.ext.ExtTGym;

import java.util.List;
import java.util.Map;

public interface ExtTGymMapper {
    List<ExtTGym> queryList(Map<String, Object> keys);

    List<ExtTGym> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TGym record);

    List<ExtTGym> queryListByLocation(Map<String, Object> keys);

    List<ExtTGym> queryListByLocation();

    int queryTotalByLocation(Map<String, Object> keys);

    int queryTotalByLocation();
}
