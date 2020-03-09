package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserFavoriteMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserFavoriteMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavorite;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavoriteExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserFavorite;
import com.coretheorylife.modules.purchaser.service.TPurchaserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserFavoriteService")
public class TPurchaserFavoriteServiceImpl extends BaseServiceImpl<TPurchaserFavorite, TPurchaserFavoriteExample> implements TPurchaserFavoriteService {

    @Autowired
    private TPurchaserFavoriteMapper tPurchaserFavoriteMapper;

    @Autowired
    private ExtTPurchaserFavoriteMapper extTPurchaserFavoriteMapper;

    @Override
    public int save(TPurchaserFavorite t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserFavoriteMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserFavorite t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserFavoriteMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserFavorite t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserFavorite queryObject(Long id) {
        return tPurchaserFavoriteMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserFavorite> queryList(Map<String, Object> keys) {
        return extTPurchaserFavoriteMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserFavorite> queryList() {
        return extTPurchaserFavoriteMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserFavoriteMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserFavoriteMapper.queryTotal();
    }
}
