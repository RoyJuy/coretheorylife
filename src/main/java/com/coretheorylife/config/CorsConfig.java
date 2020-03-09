package com.coretheorylife.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 创 建 人：Connor
 * 创建时间：2017/11/22 13:51
 * 说    明：
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter{
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//                .allowedHeaders("Content-Type,X-Requested-With,token")
                .allowCredentials(true).maxAge(3600);
            }


//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                logger.info("跨域配置");
//                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS").allowedHeaders("Content-Type,X-Requested-With,token");
//            }
//        };
//    }
}
