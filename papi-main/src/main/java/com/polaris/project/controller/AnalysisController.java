package com.polaris.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.entity.UserInterfaceInfo;
import com.polaris.project.annotation.AuthCheck;
import com.polaris.project.common.BaseResponse;
import com.polaris.project.common.ErrorCode;
import com.polaris.project.common.ResultUtils;
import com.polaris.project.exception.BusinessException;
import com.polaris.project.mapper.UserInterfaceInfoMapper;
import com.polaris.project.model.vo.InterfaceCountVO;
import com.polaris.project.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.polaris.project.constant.UserConstant.ADMIN_ROLE;

/**
 * @Author polaris
 * @Create 2024-03-28 16:28
 * @Version 1.0
 * ClassName AnalysisController
 * Package com.polaris.project.controller
 * Description 用于接口调用情况的统计分析
 */
@RestController
@Slf4j
@RequestMapping("/analysis")
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;
    @Resource
    private InterfaceInfoService interfaceInfoService;

    /*  Description
     *  用于统计分析接口调用情况的接口
     * @author polaris
     * @create 2024/3/28
     */
    @GetMapping("top/interface/invoke")
    @AuthCheck(mustRole = ADMIN_ROLE)
    public BaseResponse<List<InterfaceCountVO>> listTopInvokeInterface(){
        // 查询调用次数最多的接口
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInterface(3);
        // 接口信息按ID分组便于关联查询
        Map<Long, List<UserInterfaceInfo>> interfaceIdObjMap = userInterfaceInfoList.stream().collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        // 根据ID查询对应的接口
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceIdObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        // 把接口信息填充到 InterfaceCountVO 封装类
        List<InterfaceCountVO> interfaceCountVOList = list.stream().map(interfaceInfo -> {
            InterfaceCountVO vo = new InterfaceCountVO();
            BeanUtils.copyProperties(interfaceInfo, vo);
            vo.setTotalNum(interfaceIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum());
            return vo;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceCountVOList);
    }
}
