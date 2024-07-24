package com.polaris.project.constant;

/**
 * @author polaris
 * @version 1.0
 * ClassName RedisConstant
 * Package com.polaris.project.constant
 * Description
 * @date 2024-05-19 22:53
 */
public interface RedisConstant {
    Integer REDISSON_DATABASE = 1;
    /**
     * 签到锁前缀
     */
    public static final String DAILY_SIGN_IN_LOCK_PREFIX = "DailySignIn:Lock_UserId";
    /**
     * 签到key前缀
     */
    public static final String DAILY_SIGN_IN_KEY_PREFIX = "DailySignIn:Key_UserId";
    /**
     * 空值存在时间
     */
    Long CACHE_NULL_TTL = 2L;
    /**
     * 用户缓存存在时间
     */
    Long CACHE_LOGIN_USER_TTL = 30L;
    /**
     * 用户缓存前缀
     */
    String CACHE_LOGIN_USER_PREFIX = "cache:user:";
    /**
     * 接口缓存存在时间
     */
    Long CACHE_INTERFACE_INFO_TTL = 30L;
    /**
     * 接口缓存前缀
     */
    String CACHE_INTERFACE_INFO = "cache:interface:";

    /**
     * 接口缓存前缀
     */
    String LIMIT_PREFIX = "limit:user:";

    /**
     * 接口缓存前缀
     */
    String DEFAULT_KEY = "defaultKey";

}
