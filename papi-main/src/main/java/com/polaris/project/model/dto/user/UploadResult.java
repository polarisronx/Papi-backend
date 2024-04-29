package com.polaris.project.model.dto.user;

import lombok.Data;

/**
 * @author polaris
 * @className UploadResult
 **/
@Data
public class UploadResult {
    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件名
     */
    private String name;
    /**
     * 状态
     */
    private String status;
    /**
     * 服务端响应内容，如：'{"status": "success"}'
     */
    private String response;
    /**
     * 图像url
     */
    private String url;
}
