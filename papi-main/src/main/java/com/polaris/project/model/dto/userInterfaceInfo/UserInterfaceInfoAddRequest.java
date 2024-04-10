package com.polaris.project.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加用户-接口调用关系
 *
 * @TableName user_interface_info
 * @author polaris
 *
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {


    /**
     * 调用用户id
     */
    private Long userId;

    /**
     * 接口id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;


    private static final long serialVersionUID = 1L;
}