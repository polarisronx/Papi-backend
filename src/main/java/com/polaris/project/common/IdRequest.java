package com.polaris.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author polaris
 * @create 2024-03-15 16:49
 * @version 1.0
 * ClassName IdRequest
 * Package com.polaris.project.common
 * Description 传入id封装成一个对象，便于json参数传递
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
