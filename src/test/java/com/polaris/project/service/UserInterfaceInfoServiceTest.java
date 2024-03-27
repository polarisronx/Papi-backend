package com.polaris.project.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author polaris
 * @Create 2024-03-22 20:47
 * @Version 1.0
 * ClassName UserInterfaceInfoServiceTest
 * Package com.polaris.project.service
 * Description
 */
@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    public void invokeCount (){
        boolean result = userInterfaceInfoService.invokeCount(1L, 1L);
        Assertions.assertTrue(result);
    }
}