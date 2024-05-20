package com.polaris.project.manager.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import com.polaris.project.config.AliyunOssConfig;
import com.polaris.project.model.dto.user.UploadResult;

import com.polaris.project.manager.AliyunOssService;
import com.polaris.project.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


/**
 * @author polaris
 * @version 1.0
 * ClassName AliyunOssServiceImpl
 * Package com.polaris.project.service.impl
 * Description
 * @create 2024-04-24 14:03
 */
@Component
@Slf4j
public class AliyunOssManager implements AliyunOssService {
    private static final String[] IMAGE_TYPES = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Resource
    OSSClient ossClient;

    @Resource
    AliyunOssConfig aliyunOssConfig;



    /**
     * 文件上传
     *
     * @param uploadFile
     * @return
     */
    @Override
    public UploadResult uploadImage(MultipartFile uploadFile) {
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPES) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        // 封装Result对象，并且将文件的byte数组放置到result对象中
        UploadResult fileUploadDto = new UploadResult();
        if (!isLegal) {
            fileUploadDto.setStatus("error");
            return fileUploadDto;
        }
        // 文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String newFileName = getFilePath(fileName);
        // 上传到阿里云
        try {
            byte[] imageData = uploadFile.getBytes();
            InputStream inputStream = new ByteArrayInputStream(imageData);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(imageData.length);
            PutObjectResult putObjectResult = ossClient.putObject(aliyunOssConfig.getBucket(), newFileName, inputStream, metadata);//arg1:bucket名称,arg2:上传到的路径和文件名,arg3:上传文件流,arg4:文件元信息
            log.info(String.valueOf(putObjectResult));
        } catch (Exception e) {
            log.error(e.getMessage());
            // 上传失败
            fileUploadDto.setStatus("error");
            return fileUploadDto;
        }
        fileUploadDto.setStatus("done");
        fileUploadDto.setResponse("success");
        // 文件路径需要保存到数据库
        fileUploadDto.setName(newFileName);
        fileUploadDto.setUid(String.valueOf(System.currentTimeMillis()));
        fileUploadDto.setUrl(aliyunOssConfig.getPrefix() + newFileName);
        return fileUploadDto;
    }

    /**
     * 生成路径以及文件名
     *
     * @param sourceFileName
     * @return
     */
    private String getFilePath(String sourceFileName) {
        Long userId = UserHolder.getUser().getId();
        return "papi/" +new DateTime().toString("yyyy/MM/dd")+ "/user-" + userId + RandomUtil.randomInt(100, 9999) + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
    }
}
