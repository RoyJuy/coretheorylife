package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.gym.entity.TGymAccount;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccount;

import java.util.List;
import java.util.Map;

public interface ExtTGymAccountMapper {
    List<ExtTGymAccount> queryList(Map<String, Object> keys);

    List<ExtTGymAccount> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TGymAccount record);
}
