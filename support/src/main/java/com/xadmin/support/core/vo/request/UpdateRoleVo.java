package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加/修改角色信息")
public class UpdateRoleVo {
    @ApiModelProperty(value = "角色名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色描述", required = true)
    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
