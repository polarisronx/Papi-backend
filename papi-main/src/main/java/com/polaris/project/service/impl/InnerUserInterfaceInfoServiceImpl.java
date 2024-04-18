package com.polaris.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.common.entity.UserInterfaceInfo;
import com.polaris.common.service.InnerUserInterfaceInfoService;
import com.polaris.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @Author polaris
 * @Create 2024-03-27 21:06
 * @Version 1.0
 * ClassName InnerUserInterfaceInfoServiceImpl
 * Package com.polaris.utils.service.impl
 * Description
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    /*
     * 接口调用次数计数
     * @param null
     * @return
     * @author polaris
     * @create 2024/3/27
     **/
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    public boolean invokeCount (long interfaceInfoId, long userId){
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public int leftCount (long interfaceInfoId, long userId){
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);
        return userInterfaceInfoService.getOne(queryWrapper).getLeftNum();
    }
}
