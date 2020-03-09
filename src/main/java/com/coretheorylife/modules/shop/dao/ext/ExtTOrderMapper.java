package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;

import java.util.List;
import java.util.Map;

public interface ExtTOrderMapper {

    List<ExtTOrder> queryList(Map<String, Object> keys);

    List<ExtTOrder> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 根据店铺id或用户id查询订单
     *
     * @param keys
     * @return
     */
    List<ExtTOrder> queryListByShopIdOrUserId(Map<String, Object> keys);

    int queryTotalByShopIdOrUserId(Map<String, Object> keys);

    int insertSelective(TOrder t);
}
