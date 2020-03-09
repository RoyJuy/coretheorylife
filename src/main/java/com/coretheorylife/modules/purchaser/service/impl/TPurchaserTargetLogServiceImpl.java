package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserTargetLogMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserTargetLogMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserTargetLogService")
public class TPurchaserTargetLogServiceImpl extends BaseServiceImpl<TPurchaserTargetLog, TPurchaserTargetLogExample> implements TPurchaserTargetLogService {

    private static final String LOCK_PREFIX = "purchaser_target_log_save";

    @Autowired
    private TPurchaserTargetLogMapper tPurchaserTargetLogMapper;

    @Autowired
    private ExtTPurchaserTargetLogMapper extTPurchaserTargetLogMapper;

    @Autowired
    private TPurchaserTargetService tPurchaserTargetService;

    @Override
    public List<ExtTPurchaserTargetLog> queryList(Map<String, Object> keys) {
        return extTPurchaserTargetLogMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserTargetLog> queryList() {
        return extTPurchaserTargetLogMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserTargetLogMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserTargetLogMapper.queryTotal();
    }

    @Override
    public TPurchaserTargetLog queryOneDayRecord(Long targetId, Date date) {
        TPurchaserTargetLogExample example = new TPurchaserTargetLogExample();
        TPurchaserTargetLogExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andTargetIdEqualTo(targetId);
        criteria.andTargetTimeEqualTo(date);
        List<TPurchaserTargetLog> list = tPurchaserTargetLogMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX)
    @Override
    public int save(Long targetId, Long purchaserId) {
        TPurchaserTargetLog check = queryOneDayRecord(targetId, DateUtils.getToday());
        if (check != null) {
            throw new InvalidParameterException("今天的小目标已经完成，明天记得来哟");
        }
        TPurchaserTargetLog tPurchaserTargetLog = new TPurchaserTargetLog();
        tPurchaserTargetLog.setPurchaserId(purchaserId);
        tPurchaserTargetLog.setTargetId(targetId);
        tPurchaserTargetLog.setTargetTime(new Date());
        return save(tPurchaserTargetLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TPurchaserTargetLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        // 检查次数，决定要不要更新
        TPurchaserTarget tPurchaserTarget = tPurchaserTargetService.queryObject(t.getTargetId());
        TPurchaserTargetLog log = queryOneDayRecord(t.getTargetId(), DateUtils.getYesterday());
        if (log == null) {
            tPurchaserTarget.setCount(1);
        } else {
            tPurchaserTarget.setCount(tPurchaserTarget.getCount() + 1);
        }
        tPurchaserTargetService.update(tPurchaserTarget);
        return tPurchaserTargetLogMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserTargetLog t) {
//        t.setUpdateTime(new Date());
//        t.setUpdateUser(t.getPurchaserId());
//        return tPurchaserTargetLogMapper.updateByPrimaryKeySelective(t);
        return 0;
    }

    @Override
    public int delete(Long id) {
//        TPurchaserTargetLog t = queryObject(id);
//        if (t == null) {
//            return 0;
//        }
//        t.setDeleteFlag(true);
//        t.setUpdateTime(new Date());
//        return update(t);
        return 0;
    }

    @Override
    public TPurchaserTargetLog queryObject(Long id) {
        return tPurchaserTargetLogMapper.selectByPrimaryKey(id);
    }
}
