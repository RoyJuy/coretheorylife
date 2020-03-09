package com.coretheorylife.modules.handler;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.gym.entity.TGymToken;
import com.coretheorylife.modules.gym.service.TGymTokenService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserToken;
import com.coretheorylife.modules.purchaser.service.TPurchaserTokenService;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.service.TShopTokenService;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    private TShopTokenService tShopTokenService;

    @Autowired
    private TPurchaserTokenService tPurchaserTokenService;

    @Autowired
    private TGymTokenService tGymTokenService;

    public static final String USER_KEY = "userId";

    public boolean commonPreHandle(HttpServletRequest request, HttpServletResponse response, Object handler, String role) throws Exception {
        AuthIgnore annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        } else {
            return true;
        }
        //如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpResponse.setHeader("Access-control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
            httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-Control-Request-Headers"));
            httpResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        } //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }

        //token为空
        if (StringUtils.isBlank(token)) {
            throw new InvalidParameterException("token不能为空");
        }

        if (role.equals("shop")) {
            //查询token信息
            TShopToken tokenEntity = tShopTokenService.queryByToken(token);
            if (tokenEntity == null || tokenEntity.getExpiredTime().getTime() < System.currentTimeMillis()) {
                responseMessage(httpResponse);
                LogUtil.debug(BaseHandlerInterceptorAdapter.class, "token失效，请重新登录");
                return false;
            }
            request.setAttribute(USER_KEY, tokenEntity.getShopId());
        }

        if (role.equals("purchaser")) {
            //查询token信息
            TPurchaserToken tokenEntity = tPurchaserTokenService.queryByToken(token);
            if (tokenEntity == null || tokenEntity.getExpiredTime().getTime() < System.currentTimeMillis()) {
                responseMessage(httpResponse);
                LogUtil.debug(BaseHandlerInterceptorAdapter.class, "token失效，请重新登录");
                return false;
            }
            request.setAttribute(USER_KEY, tokenEntity.getPurchaserId());
        }

        if (role.equals("gym")) {
            //查询token信息
            TGymToken tokenEntity = tGymTokenService.queryByToken(token);
            if (tokenEntity == null || tokenEntity.getExpiredTime().getTime() < System.currentTimeMillis()) {
                responseMessage(httpResponse);
                LogUtil.debug(BaseHandlerInterceptorAdapter.class, "token失效，请重新登录");
                return false;
            }
            request.setAttribute(USER_KEY, tokenEntity.getUserId());
        }
        return true;
    }

    private void responseMessage(HttpServletResponse httpResponse) throws Exception {
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-control-Allow-Origin", "*");
        Object object = Result.failAtClient("token失效，请重新登录");
        String json = new Gson().toJson(object);
        httpResponse.getWriter().print(json);
    }

}
