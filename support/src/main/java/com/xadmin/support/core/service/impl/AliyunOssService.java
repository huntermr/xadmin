package com.xadmin.support.core.service.impl;

import com.aliyun.oss.OSSClient;
import com.xadmin.support.core.constants.CoreConstants;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Service
public class AliyunOssService {
    public String upload(MultipartFile file) {
        String objectName = String.valueOf(System.currentTimeMillis()) + getFileSuffix(file);

        try {
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(CoreConstants.ALIYUN_OSS_ENDPOINT, CoreConstants.ALIYUN_OSS_ACCESSKEYID, CoreConstants.ALIYUN_OSS_ACCESSKEYSECRET);

            // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
            ossClient.putObject(CoreConstants.ALIYUN_OSS_BUCKETNAME, objectName, file.getInputStream());

            // 关闭OSSClient。
            ossClient.shutdown();

            return new URL("http", CoreConstants.ALIYUN_OSS_BUCKET_URL, "/" + objectName).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取文件后缀
     * @param file 文件
     * @return 结果
     */
    private String getFileSuffix(MultipartFile file){
        if (file.isEmpty()){
            return null;
        }

        String filename = file.getOriginalFilename();

        if(StringUtils.isEmpty(filename)){
            return null;
        }

        if (filename.indexOf(".") > 0){
            return filename.substring(filename.lastIndexOf("."));
        }

        return null;
    }
}
