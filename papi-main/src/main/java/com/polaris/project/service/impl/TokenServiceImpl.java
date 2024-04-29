package com.polaris.project.service.impl;

import cn.hutool.core.lang.UUID;
import com.polaris.common.entity.User;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.project.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.concurrent.TimeUnit;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.project.constant.TokenConstant.*;

/**
 * @author polaris
 * @version 1.0
 * ClassName TokenServiceImpl
 * Package com.polaris.project.service.impl
 * Description
 * @create 2024-04-12 21:15
 */
@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    public static void main (String[] args){
        createKeyPair();
    }
    /**
     * @description 创建accessToken
     * 包含自定义载荷：用户账号、用户角色、用户头像、用户昵称
     * 过期时间 1天
     * @author polaris
     * @create 2024/4/14
     * @return {@link String}
     */

    @Override
    public String createAccessToken (User user){
        try {
            //02 JWT 载荷 Payload
            JwtClaims claims = new JwtClaims();
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //IssuedAt time 签发时间
            NumericDate date = NumericDate.now();
            claims.setIssuedAt(date);
//            //expire time 过期时间
//            date.addSeconds(ACCESS_TOKEN_EXPIRATION_TIME);
//            claims.setExpirationTime(date);
            // 生效时间
            claims.setNotBeforeMinutesInThePast(1);
            // Subject 面向的用户
            claims.setSubject(user.getId().toString());
            //添加自定义参数,必须是字符串类型
            claims.setClaim("avatar_url",user.getUserAvatar());
            claims.setClaim("account", user.getUserAccount());
            claims.setClaim("username",user.getUserName());
            claims.setClaim("role",user.getUserRole());

            //03 JWT 签名 Signature
            JsonWebSignature jws = new JsonWebSignature();
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);// 签名算法RS256
            jws.setKeyIdHeaderValue(KEY_ID);
            jws.setPayload(claims.toJson());
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(PRIVATE_KEY)).getPrivateKey();
            jws.setKey(privateKey);

            // 生成token
            String token = jws.getCompactSerialization();
            // 将access_token存入redis
            String key = ACCESS_TOKEN_PREFIX + user.getId();
            stringRedisTemplate.opsForValue().set(key, token, ACCESS_TOKEN_EXPIRATION_TIME, TimeUnit.SECONDS);
            return token;
        } catch (Exception e) {
            log.error("create AccessToken Exception:"+e.getMessage());
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AccessToken创建失败");
        }
    }

    /**
     * @Description 创建refresh_token
     * 包含自定义载荷 用户id
     * 过期时间 4倍 access_token
     * @author polaris
     * @create 2024/4/14
     * @return {@link String}
     */

    @Override
    public String createRefreshToken (User user){
        try {
            //02 JWT 载荷 Payload
            JwtClaims claims = new JwtClaims();
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //IssuedAt time 签发时间
            NumericDate date = NumericDate.now();
            claims.setIssuedAt(date);
//            expire time 过期时间
            date.addSeconds(REFRESH_TOKEN_EXPIRATION_TIME);
            claims.setExpirationTime(date);
            // 生效时间
            claims.setNotBeforeMinutesInThePast(1);
            // Subject 面向的用户
            claims.setSubject(user.getId().toString());

            //03 JWT 签名 Signature
            JsonWebSignature jws = new JsonWebSignature();
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);// 签名算法RS256
            jws.setKeyIdHeaderValue(KEY_ID);
            jws.setPayload(claims.toJson());
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(PRIVATE_KEY)).getPrivateKey();
            jws.setKey(privateKey);

            // 生成token
            String token = jws.getCompactSerialization();
            // 将refresh_token存入redis
            String key = REFRESH_TOKEN_PREFIX + user.getId();
            stringRedisTemplate.opsForValue().set(key, token, REFRESH_TOKEN_EXPIRATION_TIME, TimeUnit.SECONDS);
            return token;
        } catch (Exception e) {
            log.error("create RefreshToken Exception:"+e.getMessage());
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "RefreshToken创建失败");
        }
    }

    /**
     * @Description 验证token是否有效，有效返回用户信息，无效返回null
     * @author polaris
     * @create 2024/4/14
     * @return {@link User}
     */
    @Override
    public User validateToken (String token){
        try {
            JwtClaims claims = getJwtClaims(token);
            // 取出token中的用户信息
            String userId = claims.getSubject();
            String avatarUrl = (String) claims.getClaimValue("avatar_url") ;
            String userRole = (String) claims.getClaimValue("role");
            String account = (String)claims.getClaimValue("account");
            String userName = (String)claims.getClaimValue("username");
            // 验证token是否有效，如果有效，返回用户信息
            String key = ACCESS_TOKEN_PREFIX + userId;
            String storedToken = stringRedisTemplate.opsForValue().get(key);
            if (storedToken != null && storedToken.equals(token)) {
                // 如果Redis中存储的令牌与传入的令牌匹配，则验证通过
                return new User(Long.parseLong(userId), account, userName ,avatarUrl,userRole);
            }
        } catch (Exception e) {
            // 解析过程中发生异常，验证失败
            log.error("JWT解析异常: {}", e.getMessage());
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Token解析异常");
        }
        return null;
    }

    private static JwtClaims getJwtClaims (String token){
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
//                    .setRequireExpirationTime()
                    .setMaxFutureValidityInMinutes(MAX_FUTURE_VALIDITY_IN_MINUTES)
                    .setAllowedClockSkewInSeconds(ALLOWED_CLOCK_SKEW_IN_SECONDS)
                    .setRequireSubject()
                    .setVerificationKey(new RsaJsonWebKey(JsonUtil.parseJson(PUBLIC_KEY)).getPublicKey())
                    .build();
            return consumer.processToClaims(token);
        } catch (Exception e) {
            // Token验证失败
            log.error("JWT验证失败: {}", e.getMessage());
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Token验证失败");
        }
    }

    /**
     * @Description 移除用户token
     * 用户注销、修改密码等情况需要移除token
     * @author polaris
     * @create 2024/4/14
     */
    @Override
    public void removeToken (long userId){
        String accessKey = ACCESS_TOKEN_PREFIX + userId;
        String refreshKey = REFRESH_TOKEN_PREFIX + userId;
        stringRedisTemplate.delete(accessKey);
        stringRedisTemplate.delete(refreshKey);
    }


    @Override
    public boolean isTokenExpired (String token) throws MalformedClaimException, InvalidJwtException, JoseException{
        JwtClaims claims = getJwtClaims(token);
        NumericDate expirationTime = claims.getIssuedAt();
        expirationTime.addSeconds(ACCESS_TOKEN_EXPIRATION_TIME);
        return expirationTime.isBefore(NumericDate.now());
    }
    @Override
    public User getUserFromToken(String token) throws MalformedClaimException{
        throwIf(token == null, ErrorCode.PARAMS_ERROR,"token不能为空");
        JwtClaims claims = getJwtClaims(token);
        // 取出token中的用户信息
        String userId = claims.getSubject();
        String avatarUrl = (String) claims.getClaimValue("avatar_url") ;
        String userRole = (String) claims.getClaimValue("role");
        String account = (String)claims.getClaimValue("account");
        String userName = (String)claims.getClaimValue("username");
        return new User(Long.parseLong(userId), account, userName ,avatarUrl,userRole);
    }


   /**
     * @description 创建JWT的公钥、秘钥
     * createKeyPair 用来生成唯一的keyId 通过uuid 创建公钥和私钥。这个方法只要在本地运行就好了不用在线上执行。
     * 只要keyId、公钥和私钥没有被泄漏可以一直用，不用再次执行这个方法。
     * @author polaris
     * @create 2024/4/13
     */
    public static void createKeyPair(){
        String keyId = UUID.randomUUID().toString().replace("-", "");
        RsaJsonWebKey jwk = null;
        try {
            jwk = RsaJwkGenerator.generateJwk(2048);
        } catch (JoseException e) {
            log.error("JoseException:"+e.getMessage());
        }
        assert jwk != null;
        jwk.setKeyId(keyId);
        //采用的签名算法 RS256
        jwk.setAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA256);
        String publicKey = jwk.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        String privateKey = jwk.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
        log.info("keyId={}",keyId);
        log.info("公钥 publicKeyStr={}",publicKey);
        log.info("私钥 privateKeyStr={}",privateKey);
    }
}
