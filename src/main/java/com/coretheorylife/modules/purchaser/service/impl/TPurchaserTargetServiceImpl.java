package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserTargetMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserTargetMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetExample;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTarget;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserTargetService")
public class TPurchaserTargetServiceImpl extends BaseServiceImpl<TPurchaserTarget, TPurchaserTargetExample> implements TPurchaserTargetService {

    @Autowired
    private TPurchaserTargetMapper tPurchaserTargetMapper;

    @Autowired
    private ExtTPurchaserTargetMapper extTPurchaserTargetMapper;

    @Autowired
    private TPurchaserTargetLogService tPurchaserTargetLogService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TPurchaserTarget t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        t.setLasttime(new Date());
        extTPurchaserTargetMapper.insertSelective(t);
        return tPurchaserTargetLogService.save(t.getId(), t.getPurchaserId());
    }

    @Override
    public int update(TPurchaserTarget t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserTargetMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserTarget t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserTarget queryObject(Long id) {
        TPurchaserTarget tPurchaserTarget = tPurchaserTargetMapper.selectByPrimaryKey(id);
        TPurchaserTargetLog yesterdayLog = tPurchaserTargetLogService.queryOneDayRecord(id, DateUtils.getYesterday());
        if (yesterdayLog == null) {
            // 昨天没打卡
            TPurchaserTargetLog logToday = tPurchaserTargetLogService.queryOneDayRecord(id, DateUtils.getToday());
            // 如果今天也没打卡 那么就执行重置
            if (logToday == null) {
                tPurchaserTarget.setCount(0);
            }
        }
        update(tPurchaserTarget);
        // 先检查今天 然后再检查昨天
        return tPurchaserTarget;
    }

    @Override
    public List<ExtTPurchaserTarget> queryList(Map<String, Object> keys) {
        return extTPurchaserTargetMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserTarget> queryList() {
        return extTPurchaserTargetMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserTargetMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserTargetMapper.queryTotal();
    }
}
