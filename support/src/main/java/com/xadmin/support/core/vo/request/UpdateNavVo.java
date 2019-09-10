package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("更新导航请求实体")
public class UpdateNavVo {
    @ApiModelProperty("导航名称")
    private String navName;
    @ApiModelProperty("导航排序")
    private Integer sort;
    @ApiModelProperty("导航状态  0 正常  1  隐藏")
    private Integer state;
    @ApiModelProperty("父级导航ID")
    private Long parentNavId;
    @ApiModelProperty("导航链接")
    private String navLink;

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getParentNavId() {
        return parentNavId;
    }

    public void setParentNavId(Long parentNavId) {
        this.parentNavId = parentNavId;
    }

    public String getNavLink() {
        return navLink;
    }

    public void setNavLink(String navLink) {
        this.navLink = navLink;
    }

}
