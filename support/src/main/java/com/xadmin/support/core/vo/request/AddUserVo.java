package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增用户")
public class AddUserVo {
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "密码(请使用32位MD5加密后传输)", required = true)
    private String password;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("所在城市代码")
    private String city;

    @ApiModelProperty("用户角色,多个以逗号分隔")
    private String userRoles;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userDepts;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userPosts;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String getUserDepts() {
        return userDepts;
    }

    public void setUserDepts(String userDepts) {
        this.userDepts = userDepts;
    }

    public String getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(String userPosts) {
        this.userPosts = userPosts;
    }
}
