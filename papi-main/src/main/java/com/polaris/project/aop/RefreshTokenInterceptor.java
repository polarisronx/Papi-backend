package com.polaris.project.aop;

import cn.hutool.core.bean.BeanUtil;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.project.utils.UserHolder;
import com.polaris.common.entity.User;
import com.polaris.project.constant.TokenConstant;
import com.polaris.project.model.dto.user.UserDTO;
import com.polaris.project.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * @author polaris
 * @className RefreshTokenInterceptor 校验和刷新token
 * @date : 2024-4-14
 **/
public class RefreshTokenInterceptor implements HandlerInterceptor {

    TokenService tokenService;

    StringRedisTemplate stringRedisTemplate;




    public RefreshTokenInterceptor (StringRedisTemplate stringRedisTemplate, TokenService tokenService){
        this.tokenService=tokenService;
        this.stringRedisTemplate=stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        // 预请求直接放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("Authorization"); //从请求头中获取JWT access_token
        if(StringUtils.isEmpty(token)){
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR,"尚未登录！");
        }
        try {
            // 校验token是否有效
            boolean isTokenExpired = tokenService.isTokenExpired(token);

            if(isTokenExpired){
                // 如果token过期 , 那么需要通过refresh_token生成一个新的access_token
                User userFromAT = tokenService.getUserFromToken(token);
                String refreshTokenKey = TokenConstant.REFRESH_TOKEN_PREFIX+ userFromAT.getId();
                String refreshToken = stringRedisTemplate.opsForValue().get(refreshTokenKey);
                if(StringUtils.isEmpty(refreshToken)){
                    throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR,"登录状态过期, 请重新登录");
                }
                // 生成新的accessToken , 同时保存到redis
                String accessToken = tokenService.createAccessToken(userFromAT);
                String accessTokenKey = TokenConstant.ACCESS_TOKEN_PREFIX +userFromAT.getId();
                stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,
                        TokenConstant.ACCESS_TOKEN_EXPIRATION_TIME, TimeUnit.SECONDS);

                // 无感刷新token, 在线程域ThreadLocal中添加用户信息UserDTO
                UserDTO userDTO = BeanUtil.copyProperties(userFromAT, UserDTO.class);
                UserHolder.saveUser(userDTO);
            }else{
                // 如果token没有过期, 校验token是否有效。然后添加用户的数据
                User user = tokenService.validateToken(token);
                UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
                UserHolder.saveUser(userDTO);
            }
            return true;
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.FORBIDDEN_ERROR, "token错误, 请重新登录");
        }
    }
}

