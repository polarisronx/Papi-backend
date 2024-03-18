package com.polaris.project.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author polaris
 * @Create 2024-03-18 20:00
 * @Version 1.0
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
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}
