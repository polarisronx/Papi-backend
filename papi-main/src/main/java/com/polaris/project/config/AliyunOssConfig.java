package com.polaris.project.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
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

    @Value("${aliyun.oss.file.bucket}")
    String bucket;



    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder().build(endpoint, accessKey, secretKey);
    }

    public String getBucket() {
        return bucket;
    }

}
