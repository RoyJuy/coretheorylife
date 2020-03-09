package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsLabelMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTGoodsLabelMapper;
import com.coretheorylife.modules.shop.entity.TGoodsLabel;
import com.coretheorylife.modules.shop.entity.TGoodsLabelExample;
import com.coretheorylife.modules.shop.service.TGoodsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tGoodsLabelService")
public class TGoodsLabelServiceImpl extends BaseServiceImpl<TGoodsLabel, TGoodsLabelExample> implements TGoodsLabelService {

    @Autowired
    private TGoodsLabelMapper tGoodsLabelMapper;

    @Autowired
    private ExtTGoodsLabelMapper extTGoodsLabelMapper;

    @Override
    public int save(TGoodsLabel t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return extTGoodsLabelMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsLabel t) {
        t.setUpdateTime(new Date());
        return tGoodsLabelMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsLabel t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsLabel queryObject(Long id) {
        return tGoodsLabelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByGoodsId(Long goodsId) {
        List<TGoodsLabel> list = queryListByGoodsId(goodsId);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        for (TGoodsLabel tGoodsInclude : list) {
            delete(tGoodsInclude.getId());
        }
        return 1;
    }

    @Override
    public List<TGoodsLabel> queryListByGoodsId(Long goodsId) {
        TGoodsLabelExample example = new TGoodsLabelExample();
        TGoodsLabelExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        criteria.andDeleteFlagEqualTo(false);
        return tGoodsLabelMapper.selectByExample(example);
    }
}
