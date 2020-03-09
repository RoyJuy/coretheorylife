package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserShopCartMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserShopCartMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCart;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCartExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserShopCart;
import com.coretheorylife.modules.purchaser.service.TPurchaserShopCartService;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserShopCartService")
public class TPurchaserShopCartServiceImpl extends BaseServiceImpl<TPurchaserShopCart, TPurchaserShopCartExample> implements TPurchaserShopCartService {

    @Autowired
    private TPurchaserShopCartMapper tPurchaserShopCartMapper;

    @Autowired
    private ExtTPurchaserShopCartMapper extTPurchaserShopCartMapper;

    @Override
    public int save(TPurchaserShopCart t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserShopCartMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserShopCart t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        if (t.getNumber() == 0) {
            return delete(t.getId());
        } else {
            return tPurchaserShopCartMapper.updateByPrimaryKeySelective(t);
        }
    }

    @Override
    public int delete(Long id) {
        TPurchaserShopCart t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserShopCart queryObject(Long id) {
        return tPurchaserShopCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTShop> queryList(Map<String, Object> keys) {
        return extTPurchaserShopCartMapper.queryList(keys);
    }

    @Override
    public List<ExtTShop> queryList() {
        return extTPurchaserShopCartMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserShopCartMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserShopCartMapper.queryTotal();
    }
}
