package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserNotifyMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserNotifyMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotify;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotifyExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;
import com.coretheorylife.modules.purchaser.service.TPurchaserNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserNotifyService")
public class TPurchaserNotifyServiceImpl extends BaseServiceImpl<TPurchaserNotify, TPurchaserNotifyExample> implements TPurchaserNotifyService {

    @Autowired
    private TPurchaserNotifyMapper tPurchaserNotifyMapper;

    @Autowired
    private ExtTPurchaserNotifyMapper extTPurchaserNotifyMapper;

    @Override
    public int save(TPurchaserNotify t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserNotifyMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserNotify t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserNotifyMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserNotify t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserNotify queryObject(Long id) {
        return tPurchaserNotifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserNotify> queryList(Map<String, Object> keys) {
        return extTPurchaserNotifyMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserNotify> queryList() {
        return extTPurchaserNotifyMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserNotifyMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserNotifyMapper.queryTotal();
    }

    @Override
    public int readNotify(Long notifyId) {
        TPurchaserNotify notify = queryObject(notifyId);
        if (notify == null) {
            throw new InvalidParameterException("消息不存在");
        }
        notify.setHasRead(true);
        return update(notify);
    }
}
