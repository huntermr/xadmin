package com.xadmin.admin.controller.rest;

import com.xadmin.admin.constants.Urls;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.service.impl.AliyunOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(Urls.COMMON_MODULE)
@Api(value = "通用模块", tags = "通用模块")
public class CommonController {
    @Autowired
    private AliyunOssService aliyunOssService;

    @RequestMapping(value = Urls.COMMON_UPLOAD, method = RequestMethod.POST)
    @ApiOperation(value = "上传文件", notes = "上传文件")
    public ResponseVo<String> uploadFile(MultipartFile file){
        String upload = aliyunOssService.upload(file);
        return new ResponseVo<>(upload);
    }
}
