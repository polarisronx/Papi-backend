package com.polaris.common.service;


import com.polaris.common.entity.InterfaceInfo;


/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-03-03 23:12:07
*/
public interface InnerInterfaceInfoService {
    /*
     * 从数据库中查接口是否存在（通过action、请求方法）
     * @param null
     * @return
     * @author polaris
     * @create 2024/3/27
     **/
    InterfaceInfo getInterfaceInfo(String action,String method);


}
