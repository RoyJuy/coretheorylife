package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymBank;
import com.coretheorylife.modules.gym.entity.TGymBankExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymBank;

import java.util.List;
import java.util.Map;

public interface TGymBankService extends BaseService<TGymBank, TGymBankExample> {

    int updateUnCheck(TGymBank record);

    List<ExtTGymBank> queryList(Map<String, Object> keys);

    List<ExtTGymBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
