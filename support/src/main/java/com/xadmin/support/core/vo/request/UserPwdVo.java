package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@ApiModel("修改用户密码")
public class UserPwdVo {
    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID为必填")
    private Long userId;
    @ApiModelProperty("密码(请使用32位MD5加密后传输)")
    @NotEmpty(message = "请输入密码")
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
