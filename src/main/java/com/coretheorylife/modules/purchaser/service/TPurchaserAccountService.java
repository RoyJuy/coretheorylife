package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccount;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountExample;

import java.math.BigDecimal;

public interface TPurchaserAccountService extends BaseService<TPurchaserAccount, TPurchaserAccountExample> {

    TPurchaserAccount initAccount(Long purchaserId);

    int withDraw(BigDecimal money, Long cardId, Long PurchaserId, String accountPassword);
}
