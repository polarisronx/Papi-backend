package com.polaris.project.model.dto.user;

import lombok.Data;

/**
 * @author polaris
 * @version 1.0
 * ClassName UserDTO
 * Package com.polaris.project.model.dto.user
 * Description 与用户登录-token相关
 * @date 2024-04-14 20:50
 */
@Data
public class UserDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户角色
     */
    private String userRole;


    public UserDTO (Long userId, String userName, String avatarUrl){
        this.id = userId;
        this.userName = userName;
        this.userAvatar = avatarUrl;
    }
}
