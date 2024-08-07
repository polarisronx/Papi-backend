package com.polaris.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 联系电话
     */
    @TableField(value = "userPhone")
    private String userPhone;

    /**
     * 个人简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户称号，用户头衔，用户职位
     */
    @TableField(value = "userTitle")
    private String userTitle;

    /**
     * 用户所属部门、团队
     */
    @TableField(value = "userGroup")
    private String userGroup;

    /**
     * papi平台通用积分
     */
    @TableField(value = "points")
    private Integer points;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户 accessKey
     */
    private String accessKey;

    /**
     * 用户 secretKey
     */
    private String secretKey;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public User (long id,String userAccount, String userName, String avatarUrl, String userRole){
        this.id=id;
        this.userName=userName;
        this.userAccount =  userAccount;
        this.userAvatar=avatarUrl;
        this.userRole=userRole;
    }

    public User (){}
}