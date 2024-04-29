package com.polaris.project.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户视图
 *
 * @TableName user
 */
@Data
public class UserVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 联系电话
     */
    private String userPhone;

    /**
     * 个人简介
     */
    private String intro;
    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户角色: user, admin
     */
    private String userRole;
    /**
     * AK
     */
    private String accessKey;

    /**
     * SK
     */
    private String secretKey;

    /**
     * SK
     */
    private String userMail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}