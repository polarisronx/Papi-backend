package com.polaris.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.common.entity.InterfaceInfo;

/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @date 2024-03-03 23:12:07
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
