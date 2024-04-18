package com.polaris.project.service;

import com.polaris.common.entity.User;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;

/**
 * @author polaris
 * @version 1.0
 * ClassName TokenService
 * Package com.polaris.project.service
 * Description 利用Redis实现双token登录
 * @create 2024-04-12 21:11
 */

public interface TokenService {
    String createAccessToken(User user);
    String createRefreshToken(User user);
    User validateToken(String token);
    void removeToken(long id);
    boolean isTokenExpired(String token) throws MalformedClaimException, InvalidJwtException, JoseException;
}
