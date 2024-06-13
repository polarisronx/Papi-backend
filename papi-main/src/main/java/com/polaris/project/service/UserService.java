package com.polaris.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.common.entity.User;
import com.polaris.project.model.dto.user.UserLoginRequest;
import com.polaris.project.model.dto.user.UserLoginViaMailRequest;
import com.polaris.project.model.dto.user.UserUpdateRequest;
import com.polaris.project.model.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

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

    long userQuickRegisterViaMail(String userAccount,String userMail, String code);

    User userLogin (UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 用户登录
     *
     * @param userLoginRequest  用户登录 请求封装包含 userAccount userPassword
     * @return 脱敏后的用户信息
     */
    String userLogin(UserLoginRequest userLoginRequest);

    /**
     * 用户邮箱验证登录
     *
     * @param userLoginViaMailRequest  用户登录 请求封装包含 userAccount userPassword
     * @return 脱敏后的用户信息
     */
    String userLoginViaMail(UserLoginViaMailRequest userLoginViaMailRequest);

    /**
     * 获取当前登录用户
     *
     * @return
     */
    UserVO getLoginUser();

    /**
     * 是否为管理员
     *
     * @return
     */
    boolean isAdmin();

    /**
     * 用户注销
     *
     */
    boolean userLogout();

    /**
     * 更新用户信息
     *
     */
    UserVO updateUserInfo (UserUpdateRequest userUpdateRequest);

    /**
     * 更新用户积分
     *
     */
    boolean updatePoint (Integer addPoint);

    User getUserById(Long userId);

}
