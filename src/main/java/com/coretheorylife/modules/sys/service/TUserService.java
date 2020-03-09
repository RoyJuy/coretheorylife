package com.coretheorylife.modules.sys.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserExample;
import com.coretheorylife.modules.sys.entity.ext.ExtTUser;

import java.util.List;
import java.util.Map;

public interface TUserService extends BaseService<TUser, TUserExample> {

    List<ExtTUser> queryList(Map<String, Object> keys);

    List<ExtTUser> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    TUser queryByMobile(String mobile);
}
