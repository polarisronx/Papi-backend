package com.polaris.project.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author polaris
 * @className AliyunOssConfig
 * @date : 2024-4-24
 **/
@Configuration
public class AliyunOssConfig {

    @Value("${aliyun.oss.file.keyid}")
    String accessKey;

    @Value("${aliyun.oss.file.keysecret}")
    String secretKey;

    @Value("${aliyun.oss.file.endpoint}")
    String endpoint;

    @Getter
    @Value("${aliyun.oss.file.bucket}")
    String bucket;

    @Getter
    @Value("${aliyun.oss.file.prefix}")
    String prefix;
    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder().build(endpoint, accessKey, secretKey);
    }

}
