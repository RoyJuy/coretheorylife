package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;

import java.util.List;
import java.util.Map;

public interface ExtTGymAccountLogMapper {
    List<ExtTGymAccountLog> queryList(Map<String, Object> keys);

    List<ExtTGymAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
