package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.gym.entity.ext.ExtTGymBank;

import java.util.List;
import java.util.Map;

public interface ExtTGymBankMapper {
    List<ExtTGymBank> queryList(Map<String, Object> keys);

    List<ExtTGymBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
