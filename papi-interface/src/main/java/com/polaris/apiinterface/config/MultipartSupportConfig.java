package com.polaris.apiinterface.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author polaris
 * @version 1.0
 * ClassName MultipartSupportConfig
 * Package com.polaris.apiinterface.config
 * Description
 * @create 2024-06-13 10:34
 */
@Configuration
public class MultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * override a new FormEncoder to match complex param
     * param include properties and MultipartFile
     * @return
     */
    @Bean
    Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }


}
