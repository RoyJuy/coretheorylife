package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopShipLogMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTShopShipLogMapper;
import com.coretheorylife.modules.shop.entity.TShopShipLog;
import com.coretheorylife.modules.shop.entity.TShopShipLogExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopShipLog;
import com.coretheorylife.modules.shop.service.TShopShipLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tShopShipLogService")
public class TShopShipLogServiceImpl extends BaseServiceImpl<TShopShipLog, TShopShipLogExample> implements TShopShipLogService {

    @Autowired
    private ExtTShopShipLogMapper extTShopShipLogMapper;

    @Autowired
    private TShopShipLogMapper tShopShipLogMapper;


    @Override
    public int save(TShopShipLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tShopShipLogMapper.insertSelective(t);
    }

    @Override
    public int update(TShopShipLog t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tShopShipLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TShopShipLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TShopShipLog queryObject(Long id) {
        return tShopShipLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTShopShipLog> queryList(Map<String, Object> keys) {
        return extTShopShipLogMapper.queryList(keys);
    }

    @Override
    public List<ExtTShopShipLog> queryList() {
        return extTShopShipLogMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTShopShipLogMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTShopShipLogMapper.queryTotal();
    }
}
