package com.polaris.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.entity.User;
import com.polaris.papiclientsdk.client.PapiClient;
import com.polaris.project.annotation.AuthCheck;
import com.polaris.project.common.*;
import com.polaris.project.constant.CommonConstant;
import com.polaris.project.constant.UserConstant;
import com.polaris.project.exception.BusinessException;
import com.polaris.project.model.dto.interfaceInfo.InterfaceInfoAddRequest;
import com.polaris.project.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.polaris.project.model.dto.interfaceInfo.InterfaceInfoUpdateRequest;
import com.polaris.project.model.dto.interfaceInfo.InterfaceInvokeRequest;

import com.polaris.project.model.enums.InterfaceStatusrEnum;
import com.polaris.project.service.InterfaceInfoService;
import com.polaris.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 接口管理
 *
 * @author polaris
 */
@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceController {

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;

    // region 增删改查

    /**
     * 创建
     *
     * @param interfaceInfoAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoAddRequest interfaceInfoAddRequest, HttpServletRequest request) {
        if (interfaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoAddRequest, interfaceInfo);
        // 校验
        interfaceInfoService.validInterfaceInfo(interfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        interfaceInfo.setUserId(loginUser.getId());
        boolean result = interfaceInfoService.save(interfaceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        long newinterfaceInfoId = interfaceInfo.getId();
        return ResultUtils.success(newinterfaceInfoId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        InterfaceInfo oldinterfaceInfo = interfaceInfoService.getById(id);
        if (oldinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 仅本人或管理员可删除
        if (!oldinterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean b = interfaceInfoService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新
     *
     * @param interfaceInfoUpdateRequest
     * @param request
     * @return
     */
    @PostMapping("/update")
    public BaseResponse<Boolean> updateInterfaceInfo(@RequestBody InterfaceInfoUpdateRequest interfaceInfoUpdateRequest,
                                            HttpServletRequest request) {
        if (interfaceInfoUpdateRequest == null || interfaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoUpdateRequest, interfaceInfo);
        // 参数校验
        interfaceInfoService.validInterfaceInfo(interfaceInfo, false);
        User user = userService.getLoginUser(request);
        long id = interfaceInfoUpdateRequest.getId();
        // 判断是否存在
        InterfaceInfo oldinterfaceInfo = interfaceInfoService.getById(id);
        if (oldinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 仅本人或管理员可修改
        if (!oldinterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<InterfaceInfo> getInterfaceInfoById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(id);
        return ResultUtils.success(interfaceInfo);
    }

    /**
     * 获取列表（仅管理员可使用）
     *
     * @param interfaceInfoQueryRequest
     * @return
     */
    @AuthCheck(mustRole = "admin")
    @GetMapping("/list")
    public BaseResponse<List<InterfaceInfo>> listInterfaceInfo(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        if (interfaceInfoQueryRequest != null) {
            BeanUtils.copyProperties(interfaceInfoQueryRequest, interfaceInfoQuery);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.list(queryWrapper);
        return ResultUtils.success(interfaceInfoList);
    }

    /**
     * 分页获取列表
     *
     * @param interfaceInfoQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    public BaseResponse<Page<InterfaceInfo>> listInterfaceInfoByPage(InterfaceInfoQueryRequest interfaceInfoQueryRequest, HttpServletRequest request) {
        if (interfaceInfoQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoQueryRequest, interfaceInfoQuery);
        long current = interfaceInfoQueryRequest.getCurrent();
        long size = interfaceInfoQueryRequest.getPageSize();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();
        String description = interfaceInfoQuery.getDescription();
        // description 需支持模糊搜索
        interfaceInfoQuery.setDescription(null);
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<InterfaceInfo> interfaceInfoPage = interfaceInfoService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(interfaceInfoPage);
    }

    @Resource
    private PapiClient papiClient;

    /**
     * 上线接口
     *
     * @param idRequest
     * @param request
     * @return
     */
    @PostMapping("/online")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> onlineInterfaceInfo(@RequestBody IdRequest idRequest,
                                                     HttpServletRequest request) {
        // 校验参数是否为空
        if (idRequest == null || idRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 1 校验接口是否存在
        long id = idRequest.getId();
        // 根据id查出接口的信息
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        // 如果查询到该接口不存在
        if (oldInterfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 2 测试接口是否可以使用
        // 测试用模拟数据
        com.polaris.papiclientsdk.model.User user = new com.polaris.papiclientsdk.model.User();
        user.setUsername("test_user");
        String nameByPost = papiClient.getNameByPost2(user);
        if (StringUtils.isBlank(nameByPost)){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "接口服务不可用");
        }
        // 3 更新接口的状态 status
        // 新建一个接口对象
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        // 设置接口的状态
        interfaceInfo.setStatus(InterfaceStatusrEnum.ONLINE.getValue());
        // 更新接口
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        // 返回成功
        return ResultUtils.success(result);
    }

    /**
     * 下线接口
     *
     * @param idRequest
     * @param request
     * @return
     */
    @PostMapping("/offline")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> offlineInterfaceInfo(@RequestBody IdRequest idRequest,
                                                     HttpServletRequest request) {
        // 校验参数是否为空
        if (idRequest == null || idRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 1 校验接口是否存在
        long id = idRequest.getId();
        // 根据id查出接口的信息
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        // 如果查询到该接口不存在
        if (oldInterfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        // 2 更新接口的状态 status
        // 新建一个接口对象
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        // 设置接口的状态
        interfaceInfo.setStatus(InterfaceStatusrEnum.OFFLINE.getValue());
        // 更新接口
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        // 返回成功
        return ResultUtils.success(result);
    }

    /**
     * 接口测试调用
     *
     * @param interfaceInvokeRequest
     * @param request
     * @return
     */
    @PostMapping("/Invoke")
    public BaseResponse<Object> invokeInterfaceInfo(@RequestBody InterfaceInvokeRequest interfaceInvokeRequest,
                                                      HttpServletRequest request) {
        // 校验参数是否为空
        if (interfaceInvokeRequest == null || interfaceInvokeRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 1 获取接口id
        long id = interfaceInvokeRequest.getId();
        // 获取用户请求参数
        String userRequestParams = interfaceInvokeRequest.getUserRequestParams();
        // 根据id查出接口的信息
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        // 如果查询到该接口不存在
        if (oldInterfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 判断接口状态，如果接口状态不是已上线状态，则抛出业务异常
        if (oldInterfaceInfo.getStatus().equals(InterfaceStatusrEnum.OFFLINE.getValue())){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口未上线");
        }
        // 获取当前登录用户的AK和SK
        User loginUser = userService.getLoginUser(request);
        String accessKey = loginUser.getAccessKey();
        String secretKey = loginUser.getSecretKey();
        PapiClient papi = new PapiClient(accessKey, secretKey);
        Gson gson = new Gson();
        // 将用户传来的请求参数转为接口中对应的对象类型
        com.polaris.papiclientsdk.model.User user = gson.fromJson(userRequestParams, com.polaris.papiclientsdk.model.User.class);
        // 调用papi接口
        String result = papi.getNameByPost2(user);
        // 返回调用结果
        return ResultUtils.success(result);
    }
    // endregion

}
