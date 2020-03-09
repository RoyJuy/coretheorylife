package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAccount;

public interface ExtTPurchaserAccountMapper {
    int insertSelective(TPurchaserAccount record);
}
