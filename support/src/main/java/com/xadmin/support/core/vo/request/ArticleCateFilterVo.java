package com.xadmin.support.core.vo.request;

import com.xadmin.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户筛选")
public class ArticleCateFilterVo extends PageRequest {

    @ApiModelProperty("分类名称关键字")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
