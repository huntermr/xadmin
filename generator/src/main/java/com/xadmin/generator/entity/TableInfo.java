package com.xadmin.generator.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 数据库表
 * 
 * @author
 */
@ApiModel
public class TableInfo
{
    @ApiModelProperty(value = "表名,支持模糊查询")
    private String tableName;
    @ApiModelProperty(value = "表注释,支持模糊查询")
    private String tableComment;
    private Date createTime;
    private Date updateTime;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
