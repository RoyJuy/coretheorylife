package com.coretheorylife.modules.sys.dao.ext;

import com.coretheorylife.modules.sys.entity.ext.ExtTUser;

import java.util.List;
import java.util.Map;

public interface ExtTUserMapper {

    List<ExtTUser> queryList(Map<String, Object> keys);

    List<ExtTUser> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
