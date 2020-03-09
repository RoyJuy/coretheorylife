package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TOrderLine;
import com.coretheorylife.modules.shop.entity.TOrderLineExample;

import java.util.List;

public interface TOrderLineService extends BaseService<TOrderLine, TOrderLineExample> {

    List<TOrderLine> queryListByOrderId(Long orderId);
}
