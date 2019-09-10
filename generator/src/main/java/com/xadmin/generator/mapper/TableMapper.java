package com.xadmin.generator.mapper;


import com.xadmin.generator.entity.TableInfo;

import java.util.List;

/**
 * 代码生成
 * 
 * @author
 */
public interface TableMapper
{
    /**
     * 查询数据库表信息
     * 
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    public List<TableInfo> selectTableList(TableInfo tableInfo);

}
