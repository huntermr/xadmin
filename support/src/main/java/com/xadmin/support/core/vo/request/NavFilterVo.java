package com.xadmin.support.core.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("导航过滤请求实体")
public class NavFilterVo {
    @ApiModelProperty("导航名称关键字")
    private String navNameKeyword;

    public String getNavNameKeyword() {
        return navNameKeyword;
    }

    public void setNavNameKeyword(String navNameKeyword) {
        this.navNameKeyword = navNameKeyword;
    }
}
