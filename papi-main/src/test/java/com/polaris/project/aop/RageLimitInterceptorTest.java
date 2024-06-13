package com.polaris.project.aop;

import org.junit.Test;
import org.redisson.api.RMapCache;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author polaris
 * @version 1.0
 * ClassName RageLimitInterceptorTest
 * Package com.polaris.project.aop
 * Description
 * @create 2024-06-10 13:49
 */
@SpringBootTest
class RageLimitInterceptorTest {
    @Resource
    private  RageLimitInterceptor rageLimitInterceptor;
    @Test
    void test() {

    }

}