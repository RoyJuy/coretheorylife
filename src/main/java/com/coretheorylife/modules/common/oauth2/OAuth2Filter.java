package com.coretheorylife.modules.common.oauth2;

import com.google.gson.Gson;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Connor 2019年11月20日
 * oauth2过滤器
 */
public class OAuth2Filter extends AuthenticatingFilter {
    /**
     * 根据请求创建Token
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return new OAuth2Token(token);
    }


    /**
     * 允许所有的OPTIONS请求
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpResponse.setHeader("Access-control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
            httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-Control-Request-Headers"));
            httpResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            LogUtil.debug(OAuth2Filter.class, "OPTIONS 请求");
            return true;
        }
        return super.preHandle(request, response);
    }


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
//        if (StringUtils.isBlank(token)) {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setContentType("application/json;charset=utf-8");
//            httpResponse.setHeader("Access-control-Allow-Origin", "*");
//            Object object = Result.failAtClient("token失效");
//            String json = new Gson().toJson(object);
//            httpResponse.getWriter().print(json);
//            LogUtil.debug(OAuth2Filter.class, "token invalid");
//            //throw new UnauthorizedException("token失效");
//            return false;
//        }
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        //处理登录失败的异常
        Throwable throwable = e.getCause() == null ? e : e.getCause();
        Object object = Result.failAtClient(throwable.getMessage());
        String json = new Gson().toJson(object);
        try {
            httpResponse.getWriter().print(json);
        } catch (IOException ex) {
            LogUtil.debug(OAuth2Filter.class, "验证错误");
        }
        return false;
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String token = httpRequest.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }

}
