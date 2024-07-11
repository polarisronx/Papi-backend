package com.polaris.project.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.polaris.common.entity.User;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.common.util.BaseResponse;
import com.polaris.common.util.ResultUtils;
import com.polaris.project.annotation.BlackListInterceptor;
import com.polaris.project.model.dto.user.*;
import com.polaris.project.manager.AliyunOssService;
import com.polaris.project.utils.DeleteRequest;
import com.polaris.project.model.vo.UserVO;
import com.polaris.project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.project.constant.RedisConstant.CACHE_LOGIN_USER_PREFIX;

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
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private AliyunOssService aliyunOssService;
    // region 登录相关

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @BlackListInterceptor(key = "userRegisterRequest", fallbackMethod = "limitErr", rageLimit = 1L,business = "register", protectLimit = 10)
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
    @BlackListInterceptor(key = "userAccount", fallbackMethod = "limitErr", rageLimit = 10L,business = "login")
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
     * @param userUpdateRequest
     * @param userUpdateRequest
     * @return
     */
    @PostMapping("/update")
    @Operation(summary = "更新用户信息")
    public BaseResponse<UserVO> updateUserInfo(UserUpdateRequest userUpdateRequest) {
        throwIf(userUpdateRequest == null, new BusinessException(ErrorCode.NOT_FOUND_ERROR));
        UserVO userVO = userService.updateUserInfo(userUpdateRequest);
        return ResultUtils.success(userVO,"更新成功");
    }
    /**
     * @Description 上传用户头像
     *       RequestPart 注解用于multipart/form-data类型的请求体 中的文件类型数据获取
     * @author polaris
     * @create 2024/6/13
     * @return {@link BaseResponse<UploadResult>}
     */

    @PostMapping("/upload/avatar")
    @Operation(summary = "上传用户头像")
    public BaseResponse<UploadResult> uploadAvatar(@RequestPart(value = "file") MultipartFile multipartFile) {
        UploadResult result;
        throwIf(multipartFile == null,ErrorCode.NOT_FOUND_ERROR,"头像不存在");
        // 执行更新用户图像操作
        result = aliyunOssService.uploadImage(multipartFile);
        throwIf(result.getStatus().equals("error"), ErrorCode.SYSTEM_ERROR, "上传头像失败!");
        return ResultUtils.success(result);
    }


    /**
     * 根据 id 获取用户
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<UserVO> getUserById(long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 查询缓存
        String json = stringRedisTemplate.opsForValue().get(CACHE_LOGIN_USER_PREFIX+id);
        if(StringUtils.isNotBlank(json)){
            return ResultUtils.success(JSONUtil.toBean(json, UserVO.class));
        }
        User userEntity = userService.getUserById(id);

        return ResultUtils.success(BeanUtil.copyProperties(userEntity, UserVO.class));
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

    public BaseResponse limitErr(){
        return ResultUtils.error(ErrorCode.NO_ACCESS_ERROR, "账号被封禁");
    }

    // endregion
}
