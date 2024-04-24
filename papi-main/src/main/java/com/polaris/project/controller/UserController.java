package com.polaris.project.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.polaris.common.entity.User;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.common.result.BaseResponse;
import com.polaris.common.result.ResultUtils;
import com.polaris.project.model.dto.user.*;
import com.polaris.project.service.AliyunOssService;
import com.polaris.project.utils.DeleteRequest;
import com.polaris.project.model.vo.UserVO;
import com.polaris.project.service.UserService;
import com.polaris.project.utils.UserHolder;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.polaris.common.exception.ThrowUtils.throwIf;

/**
 * 用户接口
 *
 * @author polaris
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    // region 登录相关

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {

        throwIf(userRegisterRequest == null,ErrorCode.NOT_FOUND_ERROR);
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();

        throwIf(StringUtils.isAnyBlank(userAccount, userPassword, checkPassword),ErrorCode.NOT_FOUND_ERROR);
        throwIf(userAccount.length() < 2,ErrorCode.PARAMS_ERROR, "用户账号过短");
        throwIf(userPassword.length() < 8 || checkPassword.length() < 8,ErrorCode.PARAMS_ERROR, "用户密码过短");
        throwIf(!userPassword.equals(checkPassword),ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");// 密码和校验密码需要相同


        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }
    /**
     * 用户注册
     *
     * @param userRegisterViaMailRequest
     * @return
     */
    @PostMapping("/registerViaMail")
    public BaseResponse<Long> userQuickRegisterViaMail(@RequestBody UserRegisterViaMailRequest userRegisterViaMailRequest) {

        throwIf(userRegisterViaMailRequest == null,ErrorCode.NOT_FOUND_ERROR);
        String userAccount = userRegisterViaMailRequest.getUserAccount();
        String code = userRegisterViaMailRequest.getCaptcha();
        String userMail = userRegisterViaMailRequest.getMailAccount();

        throwIf(StringUtils.isAnyBlank(userAccount, code, userMail),ErrorCode.NOT_FOUND_ERROR);
        throwIf(userAccount.length() < 2,ErrorCode.PARAMS_ERROR, "用户账号过短");
        throwIf(code.length() !=6,ErrorCode.PARAMS_ERROR, "验证码有误");
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        throwIf(!Pattern.matches(emailPattern, userMail),ErrorCode.PARAMS_ERROR, "不合法的邮箱地址！");

        long result = userService.userQuickRegisterViaMail(userAccount, userMail, code);
        return ResultUtils.success(result);
    }

    /**
     * 用户账户密码登录
     *
     * @param userLoginRequest
     * @return
     */
    @PostMapping("/loginViaPassword")
    public BaseResponse<String> userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        // 校验参数
        throwIf(userLoginRequest == null,ErrorCode.NOT_FOUND_ERROR);
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        throwIf(StringUtils.isAnyBlank(userAccount, userPassword),ErrorCode.PARAMS_ERROR);
        throwIf(userAccount.length() < 2,ErrorCode.PARAMS_ERROR, "账号错误");
        throwIf(userPassword.length() < 8,ErrorCode.PARAMS_ERROR, "密码错误");

        String token = userService.userLogin(userLoginRequest);
        return ResultUtils.success(token);
    }

    /**
     * 用户邮箱验证码登录
     *
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/loginViaMail")
    public BaseResponse<String> userLoginViaMail(@RequestBody UserLoginViaMailRequest userLoginRequest, HttpServletRequest request) {

        // 校验参数
        throwIf(userLoginRequest==null,ErrorCode.NOT_FOUND_ERROR);

        String emailAccount = userLoginRequest.getMailAccount();
        String code = userLoginRequest.getCaptcha();
        throwIf(StringUtils.isAnyBlank(emailAccount, code),ErrorCode.NOT_FOUND_ERROR,"参数不能为空");
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        throwIf(!Pattern.matches(emailPattern, emailAccount),ErrorCode.PARAMS_ERROR, "不合法的邮箱地址！");
        String token = userService.userLoginViaMail(userLoginRequest);
        return ResultUtils.success(token);
    }

    /**
     * 用户注销
     *
     * @return
     */
    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout() {
        
        boolean result = userService.userLogout();
        return ResultUtils.success(result);
    }

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    @GetMapping("/currentUser")
    public BaseResponse<UserVO> getLoginUser(HttpServletRequest request) {
        UserVO user = userService.getLoginUser();
        UserVO userVO = new UserVO();
        throwIf(user == null, ErrorCode.NOT_LOGIN_ERROR);
        BeanUtils.copyProperties(user, userVO);
        return ResultUtils.success(userVO);
    }

    // endregion

    // region 增删改查

    /**
     * 创建用户
     *
     * @param userAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addUser(@RequestBody UserAddRequest userAddRequest, HttpServletRequest request) {
        throwIf(userAddRequest == null,new BusinessException(ErrorCode.NOT_FOUND_ERROR));
        User user = new User();
        BeanUtils.copyProperties(userAddRequest, user);
        boolean result = userService.save(user);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(user.getId());
    }

    /**
     * 删除用户
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = userService.removeById(deleteRequest.getId());
        return ResultUtils.success(b);
    }

    /**
     * 更新用户
     * RequestPart 注解用于multipart/form-data类型的请求体 中的文件类型数据获取
     * @param userUpdateRequest
     * @param userUpdateRequest
     * @return
     */
    @PostMapping("/update")
    @Operation(summary = "更新用户信息")
    public BaseResponse<String> updateUserInfo(@RequestPart(value = "file", required = false) MultipartFile multipartFile,
                                               UserUpdateRequest userUpdateRequest) {
        userService.updateUserInfo(multipartFile,userUpdateRequest);
        return ResultUtils.success("更新成功!");
    }



    /**
     * 根据 id 获取用户
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<UserVO> getUserById(int id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtils.success(userVO);
    }

    /**
     * 获取用户列表
     *
     * @param userQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<UserVO>> listUser(UserQueryRequest userQueryRequest, HttpServletRequest request) {
        User userQuery = new User();
        if (userQueryRequest != null) {
            BeanUtils.copyProperties(userQueryRequest, userQuery);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(userQuery);
        List<User> userList = userService.list(queryWrapper);
        List<UserVO> userVOList = userList.stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(userVOList);
    }

    /**
     * 分页获取用户列表
     *
     * @param userQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    public BaseResponse<Page<UserVO>> listUserByPage(UserQueryRequest userQueryRequest, HttpServletRequest request) {
        long current = 1;
        long size = 10;
        User userQuery = new User();
        if (userQueryRequest != null) {
            BeanUtils.copyProperties(userQueryRequest, userQuery);
            current = userQueryRequest.getCurrent();
            size = userQueryRequest.getPageSize();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(userQuery);
        Page<User> userPage = userService.page(new Page<>(current, size), queryWrapper);
        Page<UserVO> userVOPage = new PageDTO<>(userPage.getCurrent(), userPage.getSize(), userPage.getTotal());
        List<UserVO> userVOList = userPage.getRecords().stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        }).collect(Collectors.toList());
        userVOPage.setRecords(userVOList);
        return ResultUtils.success(userVOPage);
    }

    // endregion
}
