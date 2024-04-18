package com.polaris.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.common.entity.User;
import com.polaris.project.model.dto.user.UserLoginRequest;
import com.polaris.project.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 * @author polaris
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    User userLogin (UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 用户登录
     *
     * @param userLoginRequest  用户登录 请求封装包含 userAccount userPassword
     * @return 脱敏后的用户信息
     */
    String userLogin(UserLoginRequest userLoginRequest);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    UserVO getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);
}
