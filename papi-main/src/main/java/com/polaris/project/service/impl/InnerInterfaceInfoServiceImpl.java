package com.polaris.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.common.service.InnerInterfaceInfoService;
import com.polaris.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author polaris
 * @data 2024-03-27 21:06
 * @version 1.0
 * ClassName InnerInterfaceInfoServiceImpl
 * Package com.polaris.utils.service.impl
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
     * @date 2024/3/27
     **/
    @Override
    public InterfaceInfo getInterfaceInfo (String action, String method){
        if (StringUtils.isAnyBlank(action,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("action",action);
        queryWrapper.eq("method",method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
