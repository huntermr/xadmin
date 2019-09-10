package com.xadmin.support.core.vo.request;

import com.xadmin.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色过滤实体")
public class RoleFilterVo extends PageRequest {
    @ApiModelProperty("角色名关键字")
    private String roleNameKeyword;

    public String getRoleNameKeyword() {
        return roleNameKeyword;
    }

    public void setRoleNameKeyword(String roleNameKeyword) {
        this.roleNameKeyword = roleNameKeyword;
    }
}
