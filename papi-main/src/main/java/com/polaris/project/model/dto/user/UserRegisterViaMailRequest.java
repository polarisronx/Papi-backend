package com.polaris.project.model.dto.user;

import lombok.Data;

/**
 * 用户注册请求体
 *
 * @author polaris
 */
@Data
public class UserRegisterViaMailRequest {
    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String mailAccount;

    private String captcha;

}
