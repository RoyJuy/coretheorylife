package com.coretheorylife.modules.sys.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.sys.dao.TUserMapper;
import com.coretheorylife.modules.sys.dao.ext.ExtTUserMapper;
import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserExample;
import com.coretheorylife.modules.sys.entity.ext.ExtTUser;
import com.coretheorylife.modules.sys.service.TUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tUserServiceImpl")
public class TUserServiceImpl extends BaseServiceImpl<TUser, TUserExample> implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private ExtTUserMapper extTUserMapper;

    @Override
    public int save(TUser tUser) {
        String salt = RandomStringUtils.randomAlphanumeric(20);
        tUser.setCreateTime(new Date());
        tUser.setUpdateTime(new Date());
        tUser.setSort(salt);
        if (tUser.getPassword() != null) {
            tUser.setPassword(new Sha256Hash(tUser.getPassword(), salt).toHex());
        }
        return tUserMapper.insertSelective(tUser);
    }

    @Override
    public int update(TUser tUser) {
        tUser.setUpdateTime(new Date());
        tUser.setUpdateUser(tUser.getId());
        return tUserMapper.updateByPrimaryKeySelective(tUser);
    }

    @Override
    public int delete(Long id) {
        TUser tUser = queryObject(id);
        if (tUser == null) {
            return 0;
        }
        tUser.setDeleteFlag(true);
        return update(tUser);
    }

    @Override
    public TUser queryObject(Long id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTUser> queryList(Map<String, Object> keys) {
        return extTUserMapper.queryList(keys);
    }

    @Override
    public List<ExtTUser> queryList() {
        return extTUserMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTUserMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTUserMapper.queryTotal();
    }

    @Override
    public TUser queryByMobile(String mobile) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        return tUsers.size() == 0 ? null : tUsers.get(0);
    }
}
