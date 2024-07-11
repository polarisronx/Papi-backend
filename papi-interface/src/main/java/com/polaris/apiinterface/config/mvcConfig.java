package com.polaris.apiinterface.config;

import com.polaris.apiinterface.aop.OriginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author polaris
 * @date 2024-4-14
 * @version 1.0
 * ClassName mvcConfig
 * Package
 * Description
 */
@Configuration
public class mvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors (InterceptorRegistry registry){

        // 用于拦截所有请求，负责校验和刷新token。
        registry.addInterceptor(new OriginInterceptor()).addPathPatterns(
                        "/**/v1/",
                        "/**/v2/").order(1);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 启动成功，访问报js找不到的问题  引入下面的配置
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }


}
