package com.polaris.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口信息
 * @TableName interface_info
 */
@TableName(value ="interface_info")
@Data
public class InterfaceInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 服务终端
     */
    private String endpoint;

    /**
     * 接口路径
     */
    private String path;

    /**
     * 操作
     */
    private String action;

    /**
     * 请求参数
     *
     * [ { "name": "username", "type": "string"} ]
     *
     */
    private String requestParams;
    /**
     * 响应参数
     */
    @TableField(value = "ResponseParams")
    private Integer responseParams;
    /**
     * 接口示意图
     */
    @TableField(value = "interfaceAvatar")
    private String interfaceAvatar;

    /**
     * 接口类型：0 文字类；1 图片类；2 文件类；3 其他
     */
    @TableField(value = "interfaceType")
    private Integer interfaceType;



    /**
     * 请求参数类型
     */
    @TableField(value = "requestType")
    private String requestType;

    /**
     * 响应类型
     */
    @TableField(value = "responseType")
    private String responseType;

    /**
     * 接口状态（0-关闭，1-开启）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    @TableLogic
    private Integer isDelete;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}