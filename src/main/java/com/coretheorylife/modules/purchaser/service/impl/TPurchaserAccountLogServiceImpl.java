package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserAccountLogMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserAccountLogMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserAccountLogService")
public class TPurchaserAccountLogServiceImpl extends BaseServiceImpl<TPurchaserAccountLog, TPurchaserAccountLogExample> implements TPurchaserAccountLogService {

    @Autowired
    private TPurchaserAccountLogMapper tPurchaserAccountLogMapper;

    @Autowired
    private ExtTPurchaserAccountLogMapper extTPurchaserAccountLogMapper;

    @Autowired
    BaseService<TPurchaserAccountLog, TPurchaserAccountLogExample> purchaserAccountLogService;

    @Override
    public int save(TPurchaserAccountLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserAccountLogMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserAccountLog t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserAccountLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserAccountLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserAccountLog queryObject(Long id) {
        return tPurchaserAccountLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserAccountLog> queryList(Map<String, Object> keys) {
        return extTPurchaserAccountLogMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserAccountLog> queryList() {
        return extTPurchaserAccountLogMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserAccountLogMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserAccountLogMapper.queryTotal();
    }

    @Override
    public TPurchaserAccountLog queryByOrderNo(String orderNo) {
        TPurchaserAccountLogExample example = new TPurchaserAccountLogExample();
        TPurchaserAccountLogExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andOrderNoEqualTo(orderNo);
        List<TPurchaserAccountLog> list = tPurchaserAccountLogMapper.selectByExample(example);
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public TPurchaserAccountLog queryOrderPayByOrderId(Long orderId) {
        TPurchaserAccountLogExample example = new TPurchaserAccountLogExample();
        TPurchaserAccountLogExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andOrderIdEqualTo(orderId);
        criteria.andPayTypeNotEqualTo(0);
        List<TPurchaserAccountLog> list = tPurchaserAccountLogMapper.selectByExample(example);
        return list.size() == 0 ? null : list.get(0);
    }
}
