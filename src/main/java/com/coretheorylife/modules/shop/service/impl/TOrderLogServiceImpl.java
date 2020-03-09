package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TOrderLogMapper;
import com.coretheorylife.modules.shop.entity.TOrderLog;
import com.coretheorylife.modules.shop.entity.TOrderLogExample;
import com.coretheorylife.modules.shop.service.TOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tOrderLogService")
public class TOrderLogServiceImpl extends BaseServiceImpl<TOrderLog, TOrderLogExample> implements TOrderLogService {

    @Autowired
    private TOrderLogMapper tOrderLogMapper;

    @Override
    public int queryCountByShopId(Long shopId) {
        TOrderLogExample example = new TOrderLogExample();
        TOrderLogExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andShopIdEqualTo(shopId);
        criteria.andCreateTimeBetween(DateUtils.getTodayBegin(), DateUtils.getTodayEnd());
        criteria.andCreateOrderFlagEqualTo(true);
        return tOrderLogMapper.countByExample(example);
    }

    @Override
    public int save(TOrderLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tOrderLogMapper.insertSelective(t);
    }

    @Override
    public int update(TOrderLog t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tOrderLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TOrderLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TOrderLog queryObject(Long id) {
        return tOrderLogMapper.selectByPrimaryKey(id);
    }
}
