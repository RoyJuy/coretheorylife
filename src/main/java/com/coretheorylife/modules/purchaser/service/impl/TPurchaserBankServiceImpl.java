package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserBankMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserBankMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBankExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserBank;
import com.coretheorylife.modules.purchaser.service.TPurchaserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tPurchaserBankServiceImpl")
public class TPurchaserBankServiceImpl extends BaseServiceImpl<TPurchaserBank, TPurchaserBankExample> implements TPurchaserBankService {

    public static final String LOCK_PREFIX = "purchaser_bank_save";

    @Autowired
    private TPurchaserBankMapper tPurchaserBankMapper;

    @Autowired
    private ExtTPurchaserBankMapper extTPurchaserBankMapper;

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "purchaserId")
    @Override
    public int save(TPurchaserBank t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        /**
         * 如果当前用户没有别的银行卡，设置当前银行卡为默认
         */
        Map<String, Object> map = new HashMap<>();
        map.put("purchaserId", t.getPurchaserId());
        map.put("deleteFlag", false);
        List<ExtTPurchaserBank> list = queryList(map);
        if (list.isEmpty()) {
            t.setDefaultCard(true);
        } else if (t.getDefaultCard() != null && t.getDefaultCard()) {
            for (ExtTPurchaserBank extTPurchaserBank : list) {
                if (extTPurchaserBank.getId().equals(t.getId())) {
                    t.setDefaultCard(true);
                } else {
                    extTPurchaserBank.setDefaultCard(false);
                    updateUnCheck(extTPurchaserBank);
                }
            }
        }
        return tPurchaserBankMapper.insertSelective(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TPurchaserBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        // 如果设置当前银行卡为默认银行卡，那么需要设置其他银行卡为非默认
        Map<String, Object> map = new HashMap<>();
        map.put("purchaserId", t.getPurchaserId());
        map.put("deleteFlag", false);
        List<ExtTPurchaserBank> list = queryList(map);
        if (t.getDefaultCard() != null) {
            if (t.getDefaultCard()) {
                for (ExtTPurchaserBank extTPurchaserBank : list) {
                    if (extTPurchaserBank.getId().equals(t.getId())) {
                        t.setDefaultCard(true);
                    } else {
                        extTPurchaserBank.setDefaultCard(false);
                        tPurchaserBankMapper.updateByPrimaryKeySelective(extTPurchaserBank);
                    }
                }
            } else {
                boolean flag = false;
                for (ExtTPurchaserBank extTPurchaserBank : list) {
                    if (extTPurchaserBank.getDefaultCard() && !extTPurchaserBank.getId().equals(t.getId())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    throw new InvalidParameterException("当前无默认银行卡，修改失败");
                }
            }
        }
        return tPurchaserBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateUnCheck(TPurchaserBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<ExtTPurchaserBank> queryList(Map<String, Object> keys) {
        return extTPurchaserBankMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserBank> queryList() {
        return extTPurchaserBankMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserBankMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserBankMapper.queryTotal();
    }
}
