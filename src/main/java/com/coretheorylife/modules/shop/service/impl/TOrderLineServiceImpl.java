package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TOrderLineMapper;
import com.coretheorylife.modules.shop.entity.TOrderLine;
import com.coretheorylife.modules.shop.entity.TOrderLineExample;
import com.coretheorylife.modules.shop.service.TOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tOrderLineService")
public class TOrderLineServiceImpl extends BaseServiceImpl<TOrderLine, TOrderLineExample> implements TOrderLineService {

    @Autowired
    private TOrderLineMapper tOrderLineMapper;

    @Override
    public int save(TOrderLine t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tOrderLineMapper.insertSelective(t);
    }

    @Override
    public int update(TOrderLine t) {
        t.setUpdateTime(new Date());
        return tOrderLineMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TOrderLine t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TOrderLine queryObject(Long id) {
        return tOrderLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TOrderLine> queryListByOrderId(Long orderId) {
        TOrderLineExample example = new TOrderLineExample();
        TOrderLineExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        criteria.andDeleteFlagEqualTo(false);
        return tOrderLineMapper.selectByExample(example);
    }
}
