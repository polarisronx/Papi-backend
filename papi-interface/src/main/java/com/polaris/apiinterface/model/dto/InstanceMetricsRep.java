package com.polaris.apiinterface.model.dto;

import lombok.Data;

/**
 * @author polaris
 * @version 1.0
 * ClassName InstanceMetricsRep
 * Package com.polaris.apiinterface.model.dto
 * Description
 * @create 2024-06-29 14:12
 */
@Data
public class InstanceMetricsRep {
    private Double  cpuUsage;
    private Double  memoryUsage;
    private Double  diskUsage;
    private Double  networkUsage;
}
