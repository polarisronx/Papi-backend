package com.polaris.project.bizmq;

import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.entity.InvokeTask;
import com.polaris.common.entity.User;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;

import com.polaris.papiclientsdk.basicapi.client.PapiClient;
import com.polaris.papiclientsdk.common.model.CommonRequest;
import com.polaris.papiclientsdk.common.model.CommonResponse;
import com.polaris.papiclientsdk.common.model.Credential;
import com.polaris.papiclientsdk.common.profile.HttpProfile;

import com.polaris.papiclientsdk.common.utils.http.HttpConnection;
import com.polaris.project.service.InterfaceInfoService;
import com.polaris.project.service.InvokeTaskService;
import com.polaris.project.service.UserService;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.project.bizzmq.PapiMqConstant.PAPI_QUEUE_NAME;
import static com.polaris.project.constant.CommonConstant.RUNNING;
import static com.polaris.project.constant.CommonConstant.SUCCESS;

@Component
@Slf4j
public class AsyncInvokeWorker {

    @Resource
    private InvokeTaskService invokeTaskService;
    @Resource
    private InterfaceInfoService interfaceInfoService;
    @Resource
    private UserService userService;


    // 指定程序监听的消息队列和确认机制
    @SneakyThrows
    @RabbitListener(queues = {PAPI_QUEUE_NAME}, ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("receiveMessage message = {}", message);
        if (StringUtils.isBlank(message)) {
            // 如果失败，消息拒绝
            channel.basicNack(deliveryTag, false, false);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "消息为空");
        }
        long taskId = Long.parseLong(message);
        InvokeTask task = invokeTaskService.getById(taskId);
        String requestParams = task.getInputParams();
        Long interfaceId = task.getInterfaceId();
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(interfaceId);
        Long userId = task.getUserId();
        User user = userService.getById(userId);

        // 获取用户的AK和SK
        String accessKey = user.getAccessKey();
        String secretKey = user.getSecretKey();
        Credential credential = new Credential(accessKey, secretKey);
        HttpProfile httpProfile = new HttpProfile(interfaceInfo.getEndpoint(), interfaceInfo.getPath(), interfaceInfo.getMethod());
        HttpConnection httpConnection = new HttpConnection(60000, 60000, 60000);
        // 创建papi客户端
        PapiClient papi = new PapiClient(credential,httpProfile,httpConnection);
        HashMap<String, Object> params = new Gson().fromJson(requestParams, new TypeToken<HashMap<String, Object>>() {}.getType());
        // 构建请求封装类
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setMethod(interfaceInfo.getMethod());
        commonRequest.setCustomizedParams(params);
        commonRequest.setPath(interfaceInfo.getPath());

        // 更新接口状态为执行中
        task.setProcessStatus(RUNNING);
        boolean b = invokeTaskService.updateById(task);
        if (!b) {
            channel.basicNack(deliveryTag, false, false);
            handleChartUpdateError(taskId, "更新图表执行中状态失败");
            return;
        }

        // 调用papi接口
        CommonResponse response;
        String action = interfaceInfo.getAction();
        try {
            Method method = papi.getClass().getMethod(action,CommonRequest.class);
            response = (CommonResponse)method.invoke(papi,commonRequest);
            log.info("调用papi接口返回结果: {}", response);
            task.setProcessStatus(SUCCESS);

            task.setOutputRes(JSONUtil.toJsonStr(response.getData()));// 返回调用结果
            boolean res = invokeTaskService.updateById(task);
            if (!res) {
                channel.basicNack(deliveryTag, false, false);
                handleChartUpdateError(taskId, "更新图表成功状态失败");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"异步执行papi接口失败");
        }
    }

    private void handleChartUpdateError(long taskId, String message) {
        InvokeTask updateTaskResult = new InvokeTask();
        updateTaskResult.setTaskId(taskId);
        updateTaskResult.setProcessStatus("failed");
        updateTaskResult.setRunningMsg(message);
        boolean updateResult = invokeTaskService.updateById(updateTaskResult);
        if (!updateResult) {
            log.error("更新图表失败状态失败" + taskId + "," + message);
        }
    }

}
