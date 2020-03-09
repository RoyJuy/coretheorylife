package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopAccountLogMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTShopAccountLogMapper;
import com.coretheorylife.modules.shop.entity.TShopAccountLog;
import com.coretheorylife.modules.shop.entity.TShopAccountLogExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;
import com.coretheorylife.modules.shop.service.TShopAccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tShopAccountLogService")
public class TShopAccountLogServiceImpl extends BaseServiceImpl<TShopAccountLog, TShopAccountLogExample> implements TShopAccountLogService {

    @Autowired
    private TShopAccountLogMapper tShopAccountLogMapper;

    @Autowired
    private ExtTShopAccountLogMapper extTShopAccountLogMapper;

    @Override
    public int save(TShopAccountLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tShopAccountLogMapper.insertSelective(t);
    }

    @Override
    public int update(TShopAccountLog t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tShopAccountLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public TShopAccountLog queryObject(Long id) {
        return tShopAccountLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTShopAccountLog> queryList(Map<String, Object> keys) {
        return extTShopAccountLogMapper.queryList(keys);
    }

    @Override
    public List<ExtTShopAccountLog> queryList() {
        return extTShopAccountLogMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTShopAccountLogMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTShopAccountLogMapper.queryTotal();
    }
}
