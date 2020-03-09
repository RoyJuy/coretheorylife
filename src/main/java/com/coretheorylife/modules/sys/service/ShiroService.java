package com.coretheorylife.modules.sys.service;

import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserToken;

import java.util.Set;

/**
 * shiro相关接口
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    TUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    TUser queryUser(Long userId);
}
