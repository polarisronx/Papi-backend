package com.polaris.common.service;

import com.polaris.common.entity.UserInterfaceInfo;


/**
* @author polaris
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @date 2024-03-21 21:31:26
*/
public interface InnerUserInterfaceInfoService {
    /*
     * 调用接口计数
     * @param null
     * @return
     * @author polaris
     * @date 2024/3/28
     **/
    boolean invokeCount(long interfaceInfoId,long userId);

    /*
     * 剩余调用次数查询
     * @param null
     * @return
     * @author polaris
     * @date 2024/3/28
     **/
    int leftCount(long interfaceInfoId,long userId);
}
