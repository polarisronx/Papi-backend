package com.polaris.apiinterface.controller;


import cn.hutool.core.bean.BeanUtil;
import com.polaris.apiinterface.model.dto.InstanceMetricsRep;
import com.polaris.apiinterface.util.ServerMetrics;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author polaris
 * @version 1.0
 * ClassName serverMetricsController
 * Package com.polaris.apiinterface.controller
 * Description
 * @create 2024-06-29 10:43
 */
@RestController
@RequestMapping("/metrics")
public class InstanceMetricsController {
    @Value("${spring.profiles.active}")
    private String profile;
    @GetMapping("/")
    public InstanceMetricsRep getInstanceMetrics(){
        return BeanUtil.copyProperties(new ServerMetrics(profile), InstanceMetricsRep.class);
    }
}
