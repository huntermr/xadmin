package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("添加/修改资源信息")
public class UpdateResourceVo {
    @ApiModelProperty(value = "资源名称", required = true)
    @NotNull
    private String resourceName;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)", required = true)
    @NotNull
    private String resourceType;
    @ApiModelProperty(value = "资源标识符", required = true)
    @NotNull
    private String resourceKey;
    @ApiModelProperty(value = "资源URI")
    private String resourceUri;
    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;
    @ApiModelProperty(value = "资源视图")
    private String resourceView;
    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;
    @ApiModelProperty(value = "父级资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "排序")
    private Integer sort;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getResourceRedirect() {
        return resourceRedirect;
    }

    public void setResourceRedirect(String resourceRedirect) {
        this.resourceRedirect = resourceRedirect;
    }

    public String getResourceView() {
        return resourceView;
    }

    public void setResourceView(String resourceView) {
        this.resourceView = resourceView;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public Long getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(Long parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
