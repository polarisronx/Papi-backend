package com.polaris.project.service;

import com.polaris.common.entity.User;
import com.polaris.project.model.dto.user.FileDTO;
import com.polaris.project.model.dto.user.UserUpdateRequest;
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
    FileDTO uploadImage(MultipartFile uploadFile);
}
