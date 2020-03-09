package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserEnvelopeMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserEnvelopeMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelopeExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.service.TPurchaserEnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserEnvelopeService")
public class TPurchaserEnvelopeServiceImpl extends BaseServiceImpl<TPurchaserEnvelope, TPurchaserEnvelopeExample> implements TPurchaserEnvelopeService {

    @Autowired
    private TPurchaserEnvelopeMapper tPurchaserEnvelopeMapper;

    @Autowired
    private ExtTPurchaserEnvelopeMapper extTPurchaserEnvelopeMapper;

    @Override
    public int save(TPurchaserEnvelope t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserEnvelopeMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserEnvelope t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserEnvelopeMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserEnvelope t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserEnvelope queryObject(Long id) {
        return tPurchaserEnvelopeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserEnvelope> queryList(Map<String, Object> keys) {
        return extTPurchaserEnvelopeMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserEnvelope> queryList() {
        return extTPurchaserEnvelopeMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserEnvelopeMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserEnvelopeMapper.queryTotal();
    }
}
