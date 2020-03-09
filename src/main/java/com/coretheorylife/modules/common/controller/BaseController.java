package com.coretheorylife.modules.common.controller;

import com.coretheorylife.common.exception.UnknowException;
import com.coretheorylife.common.utils.HttpContextUtils;
import com.coretheorylife.common.zookeeper.CuratorClientUtils;
import com.coretheorylife.modules.handler.BaseHandlerInterceptorAdapter;
import com.coretheorylife.modules.sys.entity.TUser;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.shiro.SecurityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Connor 2019年11月20日
 * Controller公共组件
 */
@Validated
@RestController
public class BaseController {

    public Long getShopId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        return Long.valueOf(request.getAttribute(BaseHandlerInterceptorAdapter.USER_KEY).toString());
    }

    public Long getPurchaserId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        return Long.valueOf(request.getAttribute(BaseHandlerInterceptorAdapter.USER_KEY).toString());
    }

    public Long getGymId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        return Long.valueOf(request.getAttribute(BaseHandlerInterceptorAdapter.USER_KEY).toString());
    }

    public TUser getSysUser() {
        return (TUser) SecurityUtils.getSubject().getPrincipal();
    }

    public Long getSysUserId() {
        return getSysUser().getId();
    }
}
