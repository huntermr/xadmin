package com.xadmin.framework.vo;

import com.xadmin.framework.constants.Constants;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/1/30.
 */

public class PageRequest {
    @ApiModelProperty("每页大小")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    @ApiModelProperty("页码")
    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
