package com.polaris.project.controller;



import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.Mail;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.common.result.BaseResponse;
import com.polaris.common.result.ResultUtils;
import com.polaris.project.model.dto.user.MailCodeRequest;
import com.polaris.project.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.UserException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.polaris.common.exception.ThrowUtils.throwIf;

/**
 * @author polaris
 * @version 1.0
 * ClassName MailController
 * Package com.polaris.project.controller
 * Description
 * @create 2024-04-19 16:54
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
     * @create 2024/4/19
     */
    @GetMapping("/sendCode")
    public BaseResponse<Boolean> sendUserMail(String mailAccount){
        throwIf(mailAccount.isEmpty(), ErrorCode.PARAMS_ERROR);
        boolean result = mailService.sendSimpleMail(mailAccount);
        return ResultUtils.success(result);
    }

}
