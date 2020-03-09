package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserFavorite;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserFavoriteMapper {
    List<ExtTPurchaserFavorite> queryList(Map<String, Object> keys);

    List<ExtTPurchaserFavorite> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
