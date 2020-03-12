package com.coretheorylife.modules.express.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * ExpressRouteResultInfo
 *
 * @author zhuhaitao
 * @since 2019-10-28
 */
@Setter
@Getter
@ToString(callSuper = true)
public class ExpressRouteResultInfo {
    private String number;
    private String type;
    private String deliverystatus;
    private String issign;
    private String expName;
    private String expSite;
    private String expPhone;
    private String courier;
    private String courierPhone;
    private String updateTime;
    private String takeTime;
    private String logo;
    private List<Map<String, Object>> list;
}
