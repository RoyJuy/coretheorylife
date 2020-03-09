package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymAccountLogMapper;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymAccountLogMapper;
import com.coretheorylife.modules.gym.entity.TGymAccountLog;
import com.coretheorylife.modules.gym.entity.TGymAccountLogExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;
import com.coretheorylife.modules.gym.service.TGymAccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGymAccountLogService")
public class TGymAccountLogServiceImpl extends BaseServiceImpl<TGymAccountLog, TGymAccountLogExample> implements TGymAccountLogService {

    @Autowired
    private TGymAccountLogMapper tGymAccountLogMapper;
    @Autowired
    private ExtTGymAccountLogMapper extTGymAccountLogMapper;

    @Override
    public List<ExtTGymAccountLog> queryList(Map<String, Object> keys) {
        return extTGymAccountLogMapper.queryList(keys);
    }

    @Override
    public List<ExtTGymAccountLog> queryList() {
        return extTGymAccountLogMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGymAccountLogMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGymAccountLogMapper.queryTotal();
    }

    @Override
    public int save(TGymAccountLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGymAccountLogMapper.insertSelective(t);
    }

    @Override
    public int update(TGymAccountLog t) {
        t.setUpdateTime(new Date());
        return tGymAccountLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public TGymAccountLog queryObject(Long id) {
        return tGymAccountLogMapper.selectByPrimaryKey(id);
    }
}
