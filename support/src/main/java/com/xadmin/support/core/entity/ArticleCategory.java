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
 * 文章分类
 * </p>
 *
 * @author Ht
 * @since 2019-07-17
 */
@TableName("core_article_category")
@ApiModel(value="ArticleCategory对象", description="文章分类")
public class ArticleCategory extends BaseModel<ArticleCategory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_category_id", type = IdType.AUTO)
    private Long articleCategoryId;

    @ApiModelProperty(value = "文章分类标题")
    private String articleCategoryName;

    @ApiModelProperty(value = "父级分类ID")
    @TableField(strategy = FieldStrategy.IGNORED)
    private Long parentCategoryId;

    @ApiModelProperty(value = "分类等级 0 顶级 1 一级  暂时只支持到一级")
    private Integer categoryLevel;

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

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
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
        return this.articleCategoryId;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
        "articleCategoryId=" + articleCategoryId +
        ", articleCategoryName=" + articleCategoryName +
        ", parentCategoryId=" + parentCategoryId +
        ", categoryLevel=" + categoryLevel +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
