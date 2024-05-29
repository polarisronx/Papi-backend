package com.polaris.project.controller;

import com.polaris.common.exception.ErrorCode;
import com.polaris.common.result.BaseResponse;
import com.polaris.common.result.ResultUtils;
import com.polaris.project.manager.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import static com.polaris.common.exception.ThrowUtils.throwIf;

/**
 * @author polaris
 * @version 1.0
 * ClassName MailController
 * Package com.polaris.project.controller
 * Description
 * @date 2024-04-19 16:54
 */
@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {


    @Resource
    private MailService mailService;
    /**
     * @Description 发送邮箱验证码
     * @author polaris
     * @date 2024/4/19
     */
    @GetMapping("/sendCode")
    public BaseResponse<Boolean> sendUserMail(String mailAccount){
        throwIf(mailAccount.isEmpty(), ErrorCode.PARAMS_ERROR);
        boolean result = mailService.sendSimpleMail(mailAccount);
        return ResultUtils.success(result);
    }

}
