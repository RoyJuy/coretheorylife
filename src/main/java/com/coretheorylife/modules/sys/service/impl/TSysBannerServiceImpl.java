package com.coretheorylife.modules.sys.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.sys.dao.TSysBannerMapper;
import com.coretheorylife.modules.sys.entity.TSysBanner;
import com.coretheorylife.modules.sys.entity.TSysBannerExample;
import com.coretheorylife.modules.sys.service.TSysBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tSysBannerService")
public class TSysBannerServiceImpl extends BaseServiceImpl<TSysBanner, TSysBannerExample> implements TSysBannerService {

    @Autowired
    private TSysBannerMapper tSysBannerMapper;

    @Override
    public int save(TSysBanner tSysBanner) {
        return 0;
    }

    @Override
    public int update(TSysBanner tSysBanner) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public TSysBanner queryObject(Long id) {
        return null;
    }

    @Override
    public List<TSysBanner> queryList(int type) {
        TSysBannerExample example =  new TSysBannerExample();
        TSysBannerExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andTypeEqualTo(type);
        example.setOrderByClause(" sort ASC ");
        return tSysBannerMapper.selectByExample(example);
    }
}
