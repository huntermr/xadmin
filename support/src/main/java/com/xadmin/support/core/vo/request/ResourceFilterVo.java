package com.xadmin.support.core.vo.request;

import com.xadmin.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("资源过滤实体")
public class ResourceFilterVo extends PageRequest {
    @ApiModelProperty("资源名关键字")
    private String resourceNameKeyword;
    @ApiModelProperty(value = "父级资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)")
    private String resourceType;

    public String getResourceNameKeyword() {
        return resourceNameKeyword;
    }

    public void setResourceNameKeyword(String resourceNameKeyword) {
        this.resourceNameKeyword = resourceNameKeyword;
    }

    public Long getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(Long parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
