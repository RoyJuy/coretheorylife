package com.coretheorylife.modules.express.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ExpressRouteInfo
 *
 * @author zhuhaitao
 * @since 2019-10-28
 */
@Setter
@Getter
@ToString(callSuper = true)
public class ExpressRouteInfo  {
    private String status;
    private String msg;
    private ExpressRouteResultInfo result;
}
