package com.polaris.project.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName interfaceInfo
 * @author polaris
 * * 不需要上传用户的id，由系统自动生成
 * * 接口状态默认是关闭，有默认值就不需要用户上传
 * * 创建人由系统获取当前登录用户在后台自动上传
 * * 创建时间、更新时间和是否删除都是由系统和后台操作的
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口头像
     */
    private String interfaceAvatar;

    /**
     * 服务终端
     */
    private String endpoint;

    /**
     * 所有者
     */
    private Long userID;

    /**
     * 接口路径
     */
    private String path;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 响应参数
     */
    private String responseParams;

    /**
     * 请求内容类型
     */
    private String requestType;

    /**
     * 请求内容类型
     */
    private String responseType;

    /**
     * 操作
     */
    private String action;

    /**
     * 接口状态（0-关闭，1-开启，2-审核中）
     */
    private Integer status;

    /**
     * 请求参数封装类
     */
    private String requestClass;

    /**
     * 响应参数封装类
     */
    private String responseClass;

    /**
     * 请求类型
     */
    private String method;

    private static final long serialVersionUID = 1L;
}