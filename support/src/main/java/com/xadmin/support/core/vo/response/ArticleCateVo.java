package com.xadmin.support.core.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ArticleCateVo {
    @ApiModelProperty(value = "文章分类ID")
    private Long articleCategoryId;

    @ApiModelProperty(value = "文章分类标题")
    private String articleCategoryName;

    @ApiModelProperty(value = "分类等级 0 顶级 1 一级  暂时只支持到一级")
    private Integer categoryLevel;

    private List<ArticleCateVo> childCates;

    public Long getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Long articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getArticleCategoryName() {
        return articleCategoryName;
    }

    public void setArticleCategoryName(String articleCategoryName) {
        this.articleCategoryName = articleCategoryName;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public List<ArticleCateVo> getChildCates() {
        return childCates;
    }

    public void setChildCates(List<ArticleCateVo> childCates) {
        this.childCates = childCates;
    }
}
