package com.polaris.common.service;


import com.polaris.common.entity.User;


/**
 * 用户服务
 *
 * @author polaris
 */
public interface InnerUserService {

    /*
     * 在数据库中查是否有分配给用户的密钥（accessKey）
     * @param null
     * @return
     * @author polaris
     * @create 2024/3/27
     **/
    User getInvokeUser(String accessKey);
}
