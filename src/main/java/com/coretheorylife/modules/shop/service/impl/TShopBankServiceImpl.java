package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopBankMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTShopBankMapper;
import com.coretheorylife.modules.shop.entity.TShopBank;
import com.coretheorylife.modules.shop.entity.TShopBankExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopBank;
import com.coretheorylife.modules.shop.service.TShopBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tShopBankServiceImpl")
public class TShopBankServiceImpl extends BaseServiceImpl<TShopBank, TShopBankExample> implements TShopBankService {

    public static final String LOCK_PREFIX = "shop_bank_save";

    @Autowired
    private TShopBankMapper tShopBankMapper;

    @Autowired
    private ExtTShopBankMapper extTShopBankMapper;

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "shopId")
    @Override
    public int save(TShopBank t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        /**
         * 如果当前用户没有别的银行卡，设置当前银行卡为默认
         */
        Map<String, Object> map = new HashMap<>();
        map.put("shopId", t.getShopId());
        map.put("deleteFlag", false);
        List<ExtTShopBank> list = queryList(map);
        if (list.isEmpty()) {
            t.setDefaultCard(true);
        } else if (t.getDefaultCard() != null && t.getDefaultCard()) {
            for (ExtTShopBank extTShopBank : list) {
                if (extTShopBank.getId().equals(t.getId())) {
                    t.setDefaultCard(true);
                } else {
                    extTShopBank.setDefaultCard(false);
                    updateUnCheck(extTShopBank);
                }
            }
        }
        return tShopBankMapper.insertSelective(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TShopBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        // 如果设置当前银行卡为默认银行卡，那么需要设置其他银行卡为非默认
        Map<String, Object> map = new HashMap<>();
        map.put("shopId", t.getShopId());
        map.put("deleteFlag", false);
        List<ExtTShopBank> list = queryList(map);
        if (t.getDefaultCard() != null) {
            if (t.getDefaultCard()) {
                for (ExtTShopBank extTShopBank : list) {
                    if (extTShopBank.getId().equals(t.getId())) {
                        t.setDefaultCard(true);
                    } else {
                        extTShopBank.setDefaultCard(false);
                        tShopBankMapper.updateByPrimaryKeySelective(extTShopBank);
                    }
                }
            } else {
                boolean flag = false;
                for (ExtTShopBank extTShopBank : list) {
                    if (extTShopBank.getDefaultCard() && !extTShopBank.getId().equals(t.getId())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    throw new InvalidParameterException("当前无默认银行卡，修改失败");
                }
            }
        }
        return tShopBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TShopBank tShopBank = queryObject(id);
        if (tShopBank == null) {
            return 0;
        }
        tShopBank.setDeleteFlag(true);
        tShopBank.setUpdateTime(new Date());
        return update(tShopBank);
    }

    @Override
    public TShopBank queryObject(Long id) {
        return tShopBankMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUnCheck(TShopBank t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tShopBankMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<ExtTShopBank> queryList(Map<String, Object> keys) {
        return extTShopBankMapper.queryList(keys);
    }

    @Override
    public List<ExtTShopBank> queryList() {
        return extTShopBankMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTShopBankMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTShopBankMapper.queryTotal();
    }
}
