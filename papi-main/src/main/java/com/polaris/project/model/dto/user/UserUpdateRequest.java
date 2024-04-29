package com.polaris.project.model.dto.user;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户更新请求
 *
 * @author polaris
 */
@Data
public class UserUpdateRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

//    /**
//     * 账号
//     */
//    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 性别
     */
    private String gender;

//    /**
//     * 密码
//     */
//    private String userPassword;
    /**
     * 个人简介
     */
    @TableField(value = "intro")
    private String intro;
    /**
     * 用户联系方式
     */
    private String userPhone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1436336678L;
}