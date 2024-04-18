package com.polaris.project.config;


import com.polaris.project.aop.RefreshTokenInterceptor;
import com.polaris.project.service.TokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author polaris
 * @create 2024-4-14
 * @version 1.0
 * ClassName mvcConfig
 * Package
 * Description
 */
@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    TokenService tokenService;


    @Override
    public void addInterceptors (InterceptorRegistry registry){
        // 用于拦截所有请求，负责校验和刷新token。
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate,tokenService)).addPathPatterns("/**")
                .excludePathPatterns(
                        "/**/login",
                        "/**/register",
                        "/**/doc.html/**",
                        "/**/v3/api-docs/**",
                        "/**/swagger-ui.html/**",
                        "/**/swagger-resources/**",
                        "/**/webjars/**"

                ).order(0);
    }
}
