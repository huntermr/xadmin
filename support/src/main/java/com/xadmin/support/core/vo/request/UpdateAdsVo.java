package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("广告图banner")
public class UpdateAdsVo {
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("链接地址")
    private String link;
    @ApiModelProperty("图片地址")
    private String imageUrl;
    @ApiModelProperty("广告类型  1 首页轮播  2  开机动画")
    private Integer type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

