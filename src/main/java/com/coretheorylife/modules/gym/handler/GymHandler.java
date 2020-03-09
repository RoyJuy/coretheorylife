package com.coretheorylife.modules.gym.handler;

import com.coretheorylife.modules.handler.BaseHandlerInterceptorAdapter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 * 还需要在WebMvcConfig中配置
        * @author Connor
        */
@Component
public class GymHandler extends BaseHandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return commonPreHandle(request, response, handler, "gym");
    }
}