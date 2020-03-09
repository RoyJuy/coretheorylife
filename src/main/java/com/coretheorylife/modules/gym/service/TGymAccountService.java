package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymAccount;
import com.coretheorylife.modules.gym.entity.TGymAccountExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TGymAccountService extends BaseService<TGymAccount, TGymAccountExample> {

    List<ExtTGymAccount> queryList(Map<String, Object> keys);

    List<ExtTGymAccount> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    TGymAccount initAccount(Long GymId);

    int withDraw(BigDecimal money, Long cardId, Long GymId, String accountPassword);
}
