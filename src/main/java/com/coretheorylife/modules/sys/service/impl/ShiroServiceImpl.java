package com.coretheorylife.modules.sys.service.impl;

import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserToken;
import com.coretheorylife.modules.sys.service.ShiroService;
import com.coretheorylife.modules.sys.service.TUserService;
import com.coretheorylife.modules.sys.service.TUserTokenService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private TUserTokenService tUserTokenService;

    @Autowired
    private TUserService tUserService;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList = new ArrayList<>();
        // 查询所有权限字符串
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public TUserToken queryByToken(String token) {
        return tUserTokenService.queryByToken(token);
    }

    @Override
    public TUser queryUser(Long userId) {
        return tUserService.queryObject(userId);
    }
}
