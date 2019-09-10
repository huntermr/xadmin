package com.xadmin.support.core.vo.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "登录成功用户信息")
public class LoginResponseVo {
    @ApiModelProperty(value = "用户身份令牌")
    private String userToken;
    @ApiModelProperty(value = "用户信息")
    private UserResponseVo userInfo;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public UserResponseVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserResponseVo userInfo) {
        this.userInfo = userInfo;
    }
}
