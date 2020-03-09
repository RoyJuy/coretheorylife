package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsNutritionMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTGoodsNutritionMapper;
import com.coretheorylife.modules.shop.entity.TGoodsNutrition;
import com.coretheorylife.modules.shop.entity.TGoodsNutritionExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;
import com.coretheorylife.modules.shop.service.TGoodsNutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGoodsNutritionService")
public class TGoodsNutritionServiceImpl extends BaseServiceImpl<TGoodsNutrition, TGoodsNutritionExample> implements TGoodsNutritionService {

    @Autowired
    private TGoodsNutritionMapper tGoodsNutritionMapper;

    @Autowired
    private ExtTGoodsNutritionMapper extTGoodsNutritionMapper;

    @Override
    public List<ExtTGoodsNutrition> queryList(Map<String, Object> keys) {
        return extTGoodsNutritionMapper.queryList(keys);
    }

    @Override
    public List<ExtTGoodsNutrition> queryList() {
        return extTGoodsNutritionMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGoodsNutritionMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGoodsNutritionMapper.queryTotal();
    }

    @Override
    public int save(TGoodsNutrition t) {
        TGoodsNutritionExample example = new TGoodsNutritionExample();
        TGoodsNutritionExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(t.getName().trim());
        List<Long> list = new ArrayList<>();
        list.add(t.getShopId());
        list.add(0L);
        criteria.andShopIdIn(list);
        List<TGoodsNutrition> re = tGoodsNutritionMapper.selectByExample(example);
        if (!re.isEmpty()) {
            throw new InvalidParameterException("该材料已存在，保存失败");
        }
        t.setName(t.getName().trim());
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGoodsNutritionMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsNutrition t) {
        t.setUpdateTime(new Date());
        return tGoodsNutritionMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsNutrition t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsNutrition queryObject(Long id) {
        return tGoodsNutritionMapper.selectByPrimaryKey(id);
    }
}
