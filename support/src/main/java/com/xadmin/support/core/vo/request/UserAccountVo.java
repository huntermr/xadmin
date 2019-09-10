package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@ApiModel("用户账号相关请求实体")
public class UserAccountVo {
    @ApiModelProperty("登录方式  UPL 用户名密码登录  MACL 手机验证码登录")
    @NotNull(message = "登录方式必填")
    private String loginType;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码(请使用32位MD5加密后传输)")
    private String password;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("登录验证码")
    private String authCode;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
