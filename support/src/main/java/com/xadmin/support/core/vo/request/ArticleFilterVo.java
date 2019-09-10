package com.xadmin.support.core.vo.request;

import com.xadmin.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户筛选")
public class ArticleFilterVo extends PageRequest {

    @ApiModelProperty("文章标题关键字")
    private String keyword;
    @ApiModelProperty("分类ID")
    private Long cateId;
    @ApiModelProperty(value = "分类ID及对应子分类ID集合", hidden = true)
    private List<Long> allCateIds;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public List<Long> getAllCateIds() {
        return allCateIds;
    }

    public void setAllCateIds(List<Long> allCateIds) {
        this.allCateIds = allCateIds;
    }
}
