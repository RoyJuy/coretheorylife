package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTarget;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserTargetMapper {

    List<ExtTPurchaserTarget> queryList(Map<String, Object> keys);

    List<ExtTPurchaserTarget> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TPurchaserTarget t);
}
