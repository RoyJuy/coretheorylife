package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserMapper {

    List<ExtTPurchaser> queryList(Map<String, Object> keys);

    List<ExtTPurchaser> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TPurchaser recode);
}
