package com.xadmin.support.core.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;

import com.xadmin.framework.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * <p>
 * 资源信息
 * </p>
 *
 * @author Ht
 * @since 2019-07-17
 */
@TableName("core_resource")
@ApiModel(value="Resource对象", description="资源信息")
public class Resource extends BaseModel<Resource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resource_id", type = IdType.AUTO)
    private Long resourceId;

    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @ApiModelProperty(value = "资源类型(G 菜单组 M 菜单  O 按钮)")
    private String resourceType;

    @ApiModelProperty(value = "资源标识符")
    private String resourceKey;

    @ApiModelProperty(value = "资源路径")
    private String resourceUri;

    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;

    @ApiModelProperty(value = "资源视图")
    private String resourceView;

    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;

    @ApiModelProperty(value = "资源权限标识")
    private String resourcePerms;

    @ApiModelProperty(value = "资源等级")
    private Integer resourceLevel;

    @ApiModelProperty(value = "父级资源ID")
    @TableField(strategy = FieldStrategy.IGNORED)
    private Long parentResourceId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


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

    public Integer getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getResourcePerms() {
        return resourcePerms;
    }

    public void setResourcePerms(String resourcePerms) {
        this.resourcePerms = resourcePerms;
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

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.resourceId;
    }

    @Override
    public String toString() {
        return "Resource{" +
        "resourceId=" + resourceId +
        ", resourceName=" + resourceName +
        ", resourceType=" + resourceType +
        ", resourceKey=" + resourceKey +
        ", resourceUri=" + resourceUri +
        ", resourceRedirect=" + resourceRedirect +
        ", resourceView=" + resourceView +
        ", resourceIcon=" + resourceIcon +
        ", resourcePerms=" + resourcePerms +
        ", resourceLevel=" + resourceLevel +
        ", parentResourceId=" + parentResourceId +
        ", sort=" + sort +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
