package com.coretheorylife.modules.config;

import com.coretheorylife.modules.gym.handler.GymHandler;
import com.coretheorylife.modules.purchaser.handler.PurchaserHandler;
import com.coretheorylife.modules.shop.handler.ShopHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * MVC配置
 * 配置拦截器  用于注入API Mapping 和 请求参数
 *
 * @author Connor
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ShopHandler shopHandler;

    @Autowired
    private PurchaserHandler purchaserHandler;

    @Autowired
    private GymHandler gymHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shopHandler).addPathPatterns("/shop/**");
        registry.addInterceptor(purchaserHandler).addPathPatterns("/purchaser/**");
        registry.addInterceptor(gymHandler).addPathPatterns("/gym/**");
    }
}