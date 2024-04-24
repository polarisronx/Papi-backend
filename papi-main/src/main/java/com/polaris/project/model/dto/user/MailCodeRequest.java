package com.polaris.project.model.dto.user;



import lombok.Data;

/**
 * 用户注册请求体
 *
 * @author polaris
 */
@Data
public class MailCodeRequest {
    private String mailAccount;
    private static final long serialVersionUID = 34576134562652452L;
}
