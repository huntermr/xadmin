package com.xadmin.support.core.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ResourceResponseVo {
    @ApiModelProperty(value = "资源ID")
    private Long resourceId;
    @ApiModelProperty(value = "资源名称")
    private String resourceName;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)")
    private String resourceType;
    @ApiModelProperty(value = "资源路径")
    private String resourceUri;
    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;
    @ApiModelProperty(value = "资源视图")
    private String resourceView;
    @ApiModelProperty(value = "资源标识符")
    private String resourceKey;
    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;
    @ApiModelProperty(value = "资源权限标识")
    private String resourcePerms;
    @ApiModelProperty(value = "资源等级 0-99 0为顶级")
    private Integer resourceLevel;
    @ApiModelProperty(value = "父类资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "子级资源列表")
    private List<ResourceResponseVo> childResources;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

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

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public String getResourcePerms() {
        return resourcePerms;
    }

    public void setResourcePerms(String resourcePerms) {
        this.resourcePerms = resourcePerms;
    }

    public Integer getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
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

    public List<ResourceResponseVo> getChildResources() {
        return childResources;
    }

    public void setChildResources(List<ResourceResponseVo> childResources) {
        this.childResources = childResources;
    }
}
