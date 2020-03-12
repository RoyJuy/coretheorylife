package com.coretheorylife.modules.express.service;

import com.coretheorylife.modules.express.common.ExpressRouteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ExpressService
 *
 * @author zhuhaitao
 * @since 2020-03-12
 */
@Service
public class ExpressService {

    @Autowired
    private ExpressQuery expressQuery;

    public ExpressRouteInfo findExpressRoute(String expressNo){

        return expressQuery.query(expressNo, null);
    }
}
