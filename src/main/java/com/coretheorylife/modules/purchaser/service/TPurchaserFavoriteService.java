package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavorite;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavoriteExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserFavorite;

import java.util.List;
import java.util.Map;

public interface TPurchaserFavoriteService extends BaseService<TPurchaserFavorite, TPurchaserFavoriteExample> {

    List<ExtTPurchaserFavorite> queryList(Map<String, Object> keys);

    List<ExtTPurchaserFavorite> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
