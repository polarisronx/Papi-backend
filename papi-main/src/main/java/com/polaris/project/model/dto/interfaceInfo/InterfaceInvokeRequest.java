package com.polaris.project.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author polaris
 * @data 2024-03-18 20:00
 * @version 1.0
 * ClassName InterfaceInvokeRequest
 * Package com.polaris.project.model.dto.interfaceInfo
 * Description 接口调用测试
 */
@Data
public class InterfaceInvokeRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 请求参数
     */
    private List<Field> requestParams;

    private static final long serialVersionUID = 1L;
    @Data
    public static class Field {
        private String fieldName;
        private String value;
    }
}
