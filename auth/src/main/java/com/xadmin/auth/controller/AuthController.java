package com.xadmin.auth.controller;

import com.xadmin.auth.constants.AuthErrorCode;
import com.xadmin.framework.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Api(value = "权限相关", tags = "权限相关", hidden = true)
public class AuthController {

    @RequestMapping(value = "/unauth")
    @ApiOperation(value = "未授权的访问", notes = "未授权的访问")
    public ResponseVo unauth(){
        return new ResponseVo(AuthErrorCode.UNAUTH_ERROR.getCode(), AuthErrorCode.UNAUTH_ERROR.getDesc());
    }

}
