package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsIncludeMapper;
import com.coretheorylife.modules.shop.entity.TGoodsInclude;
import com.coretheorylife.modules.shop.entity.TGoodsIncludeExample;
import com.coretheorylife.modules.shop.service.TGoodsIncludeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tGoodsIncludeService")
public class TGoodsIncludeServiceImpl extends BaseServiceImpl<TGoodsInclude, TGoodsIncludeExample> implements TGoodsIncludeService {

    @Autowired
    private TGoodsIncludeMapper tGoodsIncludeMapper;

    @Override
    public int save(TGoodsInclude t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGoodsIncludeMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsInclude t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tGoodsIncludeMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsInclude t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsInclude queryObject(Long id) {
        return tGoodsIncludeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TGoodsInclude> queryListByGoodsId(Long goodsId) {
        TGoodsIncludeExample example = new TGoodsIncludeExample();
        TGoodsIncludeExample.Criteria criteria = example.createCriteria();
        criteria.andShopGoodsIdEqualTo(goodsId);
        criteria.andDeleteFlagEqualTo(false);
        return tGoodsIncludeMapper.selectByExample(example);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByGoodsId(Long goodsId) {
        List<TGoodsInclude> list = queryListByGoodsId(goodsId);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        for (TGoodsInclude tGoodsInclude : list) {
            delete(tGoodsInclude.getId());
        }
        return 1;
    }
}
