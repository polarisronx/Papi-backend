package com.polaris.project.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 * 创建人是不能修改的，除非是限定由管理员修改，这里不提供
 * 创建时间、更新时间和是否删除默认不能手动修改
 *
 * @TableName product
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {
    /**
     * 名称
     */
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

    /**
     * 每次调用扣除积分
     */
    private String costs;

}