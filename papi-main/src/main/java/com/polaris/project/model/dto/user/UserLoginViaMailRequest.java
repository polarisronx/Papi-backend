package com.polaris.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author polaris
 * @version 1.0
 * ClassName UserLoginViaMailRequest
 * Package com.polaris.project.model.dto.user
 * Description
 * @create 2024-04-19 19:44
 */
@Data
public class UserLoginViaMailRequest implements Serializable {
    private String mailAccount;
    private String captcha;
    private static final long serialVersionUID = 345729561345626543L;

}
