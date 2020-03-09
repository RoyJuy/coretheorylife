package com.coretheorylife.modules.sys.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.sys.entity.TSysBanner;
import com.coretheorylife.modules.sys.entity.TSysBannerExample;

import java.util.List;

public interface TSysBannerService extends BaseService<TSysBanner, TSysBannerExample> {

    List<TSysBanner> queryList(int type);
}
