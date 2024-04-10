package com.polaris.project.model.vo;

/**
 * @Author polaris
 * @Create 2024-03-28 19:23
 * @Version 1.0
 * 接口信息封装视图
 * 继承了InterfaceInfo，同时带有 调用次数 属性。
 * @TableName interfaceInfo
 */

import com.polaris.common.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InterfaceCountVO extends InterfaceInfo {
    /*
     * 调用次数
     *
     **/
    private Integer totalNum;
    private static final long serialVersionUID = 1L;
}
