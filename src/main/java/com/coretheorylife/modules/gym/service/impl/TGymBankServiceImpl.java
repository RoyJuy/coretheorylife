package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymBankMapper;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymBankMapper;
import com.coretheorylife.modules.gym.entity.TGymBank;
import com.coretheorylife.modules.gym.entity.TGymBankExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymBank;
import com.coretheorylife.modules.gym.service.TGymBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tGymBankService")
public class TGymBankServiceImpl extends BaseServiceImpl<TGymBank, TGymBankExample> implements TGymBankService {

    public static final String LOCK_PREFIX = "gym_bank_save";

    @Autowired
    private TGymBankMapper tGymBankMapper;
    
    @Autowired
    private ExtTGymBankMapper extTGymBankMapper;
    
    @Override
    public int updateUnCheck(TGymBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getGymId());
        return tGymBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<ExtTGymBank> queryList(Map<String, Object> keys) {
        return extTGymBankMapper.queryList(keys);
    }

    @Override
    public List<ExtTGymBank> queryList() {
        return extTGymBankMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGymBankMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGymBankMapper.queryTotal();
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "gymId")
    @Override
    public int save(TGymBank t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        /**
         * 如果当前用户没有别的银行卡，设置当前银行卡为默认
         */
        Map<String, Object> map = new HashMap<>();
        map.put("gymId", t.getGymId());
        map.put("deleteFlag", false);
        List<ExtTGymBank> list = queryList(map);
        if (list.isEmpty()) {
            t.setDefaultCard(true);
        } else if (t.getDefaultCard() != null && t.getDefaultCard()) {
            for (ExtTGymBank extTGymBank : list) {
                if (extTGymBank.getId().equals(t.getId())) {
                    t.setDefaultCard(true);
                } else {
                    extTGymBank.setDefaultCard(false);
                    updateUnCheck(extTGymBank);
                }
            }
        }
        return tGymBankMapper.insertSelective(t);
    }

    @Override
    public int update(TGymBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getGymId());
        // 如果设置当前银行卡为默认银行卡，那么需要设置其他银行卡为非默认
        Map<String, Object> map = new HashMap<>();
        map.put("gymId", t.getGymId());
        map.put("deleteFlag", false);
        List<ExtTGymBank> list = queryList(map);
        if (t.getDefaultCard() != null) {
            if (t.getDefaultCard()) {
                for (ExtTGymBank extTGymBank : list) {
                    if (extTGymBank.getId().equals(t.getId())) {
                        t.setDefaultCard(true);
                    } else {
                        extTGymBank.setDefaultCard(false);
                        tGymBankMapper.updateByPrimaryKeySelective(extTGymBank);
                    }
                }
            } else {
                boolean flag = false;
                for (ExtTGymBank extTGymBank : list) {
                    if (extTGymBank.getDefaultCard() && !extTGymBank.getId().equals(t.getId())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    throw new InvalidParameterException("当前无默认银行卡，修改失败");
                }
            }
        }
        return tGymBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGymBank tShopBank = queryObject(id);
        if (tShopBank == null) {
            return 0;
        }
        tShopBank.setDeleteFlag(true);
        tShopBank.setUpdateTime(new Date());
        return update(tShopBank);
    }

    @Override
    public TGymBank queryObject(Long id) {
        return tGymBankMapper.selectByPrimaryKey(id);
    }
}
