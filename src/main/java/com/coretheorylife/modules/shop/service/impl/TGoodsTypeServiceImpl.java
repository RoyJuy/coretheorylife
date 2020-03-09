package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsTypeMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTGoodsTypeMapper;
import com.coretheorylife.modules.shop.entity.TGoodsType;
import com.coretheorylife.modules.shop.entity.TGoodsTypeExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;
import com.coretheorylife.modules.shop.service.TGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGoodsTypeService")
public class TGoodsTypeServiceImpl extends BaseServiceImpl<TGoodsType, TGoodsTypeExample> implements TGoodsTypeService {

    @Autowired
    private TGoodsTypeMapper tGoodsTypeMapper;

    @Autowired
    private ExtTGoodsTypeMapper extTGoodsTypeMapper;

    @Override
    public List<ExtTGoodsType> queryList(Map<String, Object> keys) {
        return extTGoodsTypeMapper.queryList(keys);
    }

    @Override
    public List<ExtTGoodsType> queryList() {
        return extTGoodsTypeMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGoodsTypeMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGoodsTypeMapper.queryTotal();
    }

    @Override
    public List<ExtTGoodsType> queryAllGoodByShopId(Map<String, Object> keys) {
        return extTGoodsTypeMapper.queryAllGoodByShopId(keys);
    }

    @Override
    public int save(TGoodsType t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGoodsTypeMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsType t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tGoodsTypeMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsType t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsType queryObject(Long id) {
        return tGoodsTypeMapper.selectByPrimaryKey(id);
    }
}
