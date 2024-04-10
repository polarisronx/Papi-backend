package com.polaris.project;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author polaris
 * @version 1.0
 * ClassName PapiMain
 * Package com.polaris.project
 * Description
 * @create 2024-04-10 11:12
 */
@SpringBootApplication
@MapperScan("com.polaris.project.mapper")
@EnableDubbo
public class PapiMain {
    public static void main(String[] args) {
        SpringApplication.run(PapiMain.class, args);
    }
}
