package com.polaris.project.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author polaris
 * @version 1.0
 * ClassName RedisVO
 * Package com.polaris.project.model.vo
 * Description 没有侵入性在数据中添加过期时间
 * @create 2024-05-22 21:13
 */
@Data
public class RedisVO {
    private LocalDateTime expireTime;
    private Object data;
}
