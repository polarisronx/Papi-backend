package com.polaris.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.common.entity.User;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.project.mapper.UserMapper;
import com.polaris.project.model.dto.user.*;
import com.polaris.project.model.vo.UserVO;
import com.polaris.project.service.AliyunOssService;
import com.polaris.project.service.TokenService;
import com.polaris.project.service.UserService;
import com.polaris.project.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.project.constant.MailConstant.MAIL_CODE_PREFIX;
import static com.polaris.project.constant.UserConstant.ADMIN_ROLE;
import static com.polaris.project.constant.UserConstant.USER_LOGIN_STATE;


/**
 * 用户服务实现类
 *
 * @author polaris
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private TokenService tokenService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private AliyunOssService aliyunOssService;

    /**
     * 盐值，混淆密码
     */
    private static final String SALT = "polaris";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        synchronized (userAccount.intern()) {
            // 账户不能重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userAccount", userAccount);
            long count = userMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号已经存在");
            }
            // 2. 加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
            // 3. 为用户分配 accessKey和secretKey
            // 使用digestUil.md5Hex 将盐值、用户账号、随机数 进行MD5加密
            String accessKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(5));
            String secretKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(8));
            // 4. 插入数据
            User user = new User();
            user.setUserAccount(userAccount);
            user.setUserPassword(encryptPassword);
            user.setAccessKey(accessKey);
            user.setSecretKey(secretKey);
            boolean saveResult = this.save(user);
            if (!saveResult) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "注册失败，数据库错误");
            }
            return user.getId();
        }
    }

    @Override
    public long userQuickRegisterViaMail (String userAccount,String userMail, String code){
        synchronized (userAccount.intern()) {
            // 账户不能重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userAccount", userAccount);
            long count = userMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号已经存在");
            }
            // 3. 为用户分配 accessKey和secretKey
            // 使用digestUil.md5Hex 将盐值、用户账号、随机数 进行MD5加密
            String accessKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(5));
            String secretKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(8));
            // 4. 插入数据
            User user = new User();
            user.setUserAccount(userAccount);
            user.setAccessKey(accessKey);
            user.setSecretKey(secretKey);
            user.setUserMail(userMail);
            boolean saveResult = this.save(user);
            throwIf(!saveResult,ErrorCode.SYSTEM_ERROR, "注册失败，数据库错误");
            return user.getId();
        }
    }

    /**
     * @Description 通过共享session实现单点登录
     * 实现流程
     * 利用了spring的共享Session，把Session存在Redis
     * 用户每次登录，都会把用户信息作为Session的Attribute放进去，因为spring的集成，每次可以轻松地从请求中拿到Session，再从Session中获取用户信息。
     * @author polaris
     * @create 2024/4/12
     * @return {@link User}
     */
    @Override
    public User userLogin (UserLoginRequest userLoginRequest, HttpServletRequest request) {
        // 1. 获取参数
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        // 3. 记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE, user);
        return user;
    }

    /**
     * @Description 通过JWT实现单点登录
     * @author polaris
     * @create 2024/4/14
     * @return {@link String}
     */
    @Override
    public String userLogin(UserLoginRequest userLoginRequest){
        // 获取参数
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        //3. 获取token
        String token = tokenService.createAccessToken(user);
        tokenService.createRefreshToken(user);
        // 返回生成的accessToken
        return token;
    }

    @Override
    public String userLoginViaMail (UserLoginViaMailRequest userLoginViaMailRequest){
        throwIf(userLoginViaMailRequest == null, ErrorCode.PARAMS_ERROR, "参数为空");
        String mailAccount = userLoginViaMailRequest.getMailAccount();
        String code = userLoginViaMailRequest.getCaptcha();
        String codeExpected = stringRedisTemplate.opsForValue().get(MAIL_CODE_PREFIX + mailAccount);
        // 校验验证码是否过期
        throwIf(StringUtils.isBlank(codeExpected),ErrorCode.OPERATION_ERROR, "验证码已过期,请重新获取");
        // 校验验证码是否正确
        code = code.trim();
        throwIf(!codeExpected.equals(code),ErrorCode.OPERATION_ERROR, "验证码输入有误");

        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userMail", mailAccount);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        throwIf(user == null, ErrorCode.NOT_LOGIN_ERROR, "用户不存在");
        //3. 获取token
        String token = tokenService.createAccessToken(user);
        tokenService.createRefreshToken(user);
        // 返回生成的accessToken
        return token;
    }


    /**
     * 获取当前登录用户
     *
     * @return
     */
    @Override
    public UserVO getLoginUser() {
        UserDTO user = UserHolder.getUser();
        throwIf(user == null, ErrorCode.NOT_LOGIN_ERROR);
        User userEntity = getById(user.getId());// 从数据库查询（追求性能的话可以注释，直接走缓存）
        return BeanUtil.copyProperties(userEntity, UserVO.class);
    }

    /**
     * 是否为管理员
     *
     */
    @Override
    public boolean isAdmin() {
        // 仅管理员可查询
//        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
//        User user = (User) userObj;
        UserDTO user = UserHolder.getUser();
        throwIf(user == null, ErrorCode.NOT_LOGIN_ERROR);
        return user != null && ADMIN_ROLE.equals(user.getUserRole());
    }

    /**
     * 用户注销
     *
     */
    @Override
    public boolean userLogout() {
//        if (request.getSession().getAttribute(USER_LOGIN_STATE) == null) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "未登录");
//        }
//        // 移除登录态
//        request.getSession().removeAttribute(USER_LOGIN_STATE);
//        return true;
        UserHolder.removeUser();
        return true;
    }
    @Override
    public void updateUserInfo(MultipartFile multipartFile, UserUpdateRequest userUpdateRequest) {
        if (multipartFile != null) {
            // 执行更新用户图像操作
            FileDTO result = aliyunOssService.uploadImage(multipartFile);
            throwIf(result.getStatus().equals("error"), ErrorCode.SYSTEM_ERROR, "上传头像失败!");
            String url = result.getName();
            userUpdateRequest.setUserAvatar(url);
        }
        User userEntity = BeanUtil.copyProperties(userUpdateRequest, User.class);
        UserDTO user = UserHolder.getUser();
        userEntity.setId(user.getId());
        boolean b = updateById(userEntity);
        throwIf(!b, ErrorCode.SYSTEM_ERROR, "更新用户信息失败!");
    }

}




