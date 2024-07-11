package com.polaris.apiinterface.aop;


import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author polaris
 * @className RefreshTokenInterceptor 校验和刷新token
 * @date : 2024-4-14
 **/
public class OriginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        // 预请求直接放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        String origin = request.getHeader("origin"); //从请求头中获取origin
        if(StringUtils.isEmpty(origin)||!origin.equals("gateway")) {
            throw new BusinessException(ErrorCode.FORBIDDEN_ERROR, "尚未登录！");
        }
        return true;
    }
}

