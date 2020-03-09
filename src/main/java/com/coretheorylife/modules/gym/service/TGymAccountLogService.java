package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymAccountLog;
import com.coretheorylife.modules.gym.entity.TGymAccountLogExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;

import java.util.List;
import java.util.Map;

public interface TGymAccountLogService extends BaseService<TGymAccountLog, TGymAccountLogExample> {

    List<ExtTGymAccountLog> queryList(Map<String, Object> keys);

    List<ExtTGymAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
