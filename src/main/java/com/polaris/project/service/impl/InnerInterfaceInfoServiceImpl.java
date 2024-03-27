package com.polaris.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.entity.UserInterfaceInfo;
import com.polaris.common.service.InnerInterfaceInfoService;
import com.polaris.project.common.ErrorCode;
import com.polaris.project.exception.BusinessException;
import com.polaris.project.mapper.InterfaceInfoMapper;
import com.polaris.project.service.UserInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @Author polaris
 * @Create 2024-03-27 21:06
 * @Version 1.0
 * ClassName InnerInterfaceInfoServiceImpl
 * Package com.polaris.common.service.impl
 * Description
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /*
     * 查找接口，判断接口是否存在
     * @param null
     * @return
     * @author polaris
     * @create 2024/3/27
     **/
    @Override
    public InterfaceInfo getInterfaceInfo (String url, String method){
        if (StringUtils.isAnyBlank(url,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url",url);
        queryWrapper.eq("method",method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
