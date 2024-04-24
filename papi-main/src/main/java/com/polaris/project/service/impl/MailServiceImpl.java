package com.polaris.project.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.project.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.project.constant.MailConstant.*;

/**
 * @author polaris
 * @version 1.0
 * ClassName MailServiceImpl
 * Package com.polaris.project.service.impl
 * Description
 * @create 2024-04-19 19:32
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {


    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean sendSimpleMail (String sendTo){
        try {

            String key = MAIL_CODE_PREFIX + sendTo;
            // 判断当前待发送邮箱是否已经有验证码 不必
//            String code = stringRedisTemplate.opsForValue().get(key);
//            throwIf(code!=null, new BusinessException(ErrorCode.NO_SUPPORT_ERROR,"邮箱验证码已发送，请勿重复操作"));

            MimeMessageHelper messageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
            //邮件发信人
            messageHelper.setFrom(MAIL_FROM);
            //邮件收信人
            messageHelper.setTo(sendTo);
            //邮件主题
            messageHelper.setSubject(MAIL_SUBJECT);
            //邮件内容 随机6位验证码
            String mailCode = RandomUtil.randomNumbers(6);
            messageHelper.setText("您好，您正在使用Papi用户邮箱服务，您的验证码为" + mailCode + "，请在5分钟内输入，如非本人操作，请忽略本邮件。");

            //发送邮件
            javaMailSender.send(messageHelper.getMimeMessage());
            stringRedisTemplate.opsForValue().set(key, mailCode, 5, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.warn("邮件发送失败：{}", e.getMessage());
            throw new MailSendException("邮件发送失败:" + e.getMessage());
        }
    }
}
