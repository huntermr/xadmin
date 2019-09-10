package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("更新用户信息")
public class UserInfoVo {
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("所在城市代码")
    private String city;
    @ApiModelProperty("用户状态 'N' 正常 'L' 锁定")
    private String userStatus;

    @ApiModelProperty("用户角色,多个以逗号分隔")
    private String userRoles;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userDepts;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userPosts;

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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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
