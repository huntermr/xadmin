package com.xadmin.support.core.vo.request;

import com.xadmin.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户筛选")
public class UserFilterVo extends PageRequest {

    @ApiModelProperty("用户名关键字")
    private String userNameKeyword;
    @ApiModelProperty("角色ID")
    private Long roleId;
    @ApiModelProperty("用户组ID")
    private Long groupId;
    @ApiModelProperty("部门ID")
    private Long deptId;
    @ApiModelProperty(value = "部门ID及对应子部门ID集合", hidden = true)
    private List<Long> allDeptIds;

    public String getUserNameKeyword() {
        return userNameKeyword;
    }

    public void setUserNameKeyword(String userNameKeyword) {
        this.userNameKeyword = userNameKeyword;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public List<Long> getAllDeptIds() {
        return allDeptIds;
    }

    public void setAllDeptIds(List<Long> allDeptIds) {
        this.allDeptIds = allDeptIds;
    }
}
