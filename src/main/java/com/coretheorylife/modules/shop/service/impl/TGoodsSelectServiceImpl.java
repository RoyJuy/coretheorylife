package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsSelectMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTGoodsSelectMapper;
import com.coretheorylife.modules.shop.entity.TGoodsSelect;
import com.coretheorylife.modules.shop.entity.TGoodsSelectExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsSelect;
import com.coretheorylife.modules.shop.service.TGoodsSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tGoodsSelectService")
public class TGoodsSelectServiceImpl extends BaseServiceImpl<TGoodsSelect, TGoodsSelectExample> implements TGoodsSelectService {

    @Autowired
    private TGoodsSelectMapper tGoodsSelectMapper;

    @Autowired
    private ExtTGoodsSelectMapper extTGoodsSelectMapper;

    @Override
    public int save(TGoodsSelect t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGoodsSelectMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsSelect t) {
        t.setUpdateTime(new Date());
        return tGoodsSelectMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsSelect t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsSelect queryObject(Long id) {
        return tGoodsSelectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTGoodsSelect> queryList(Long goodsId) {
        return extTGoodsSelectMapper.queryList(goodsId);
    }
}
