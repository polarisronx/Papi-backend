package com.polaris.project.manager;

import com.polaris.project.model.dto.user.UploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author polaris
 * @version 1.0
 * ClassName AliyunOssService
 * Package com.polaris.project.service
 * Description
 * @create 2024-04-24 14:03
 */
public interface AliyunOssService {
    UploadResult uploadImage(MultipartFile uploadFile);
}
