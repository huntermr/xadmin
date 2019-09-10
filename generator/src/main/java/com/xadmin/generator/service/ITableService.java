package com.xadmin.generator.service;

import com.xadmin.generator.entity.TableInfo;

import java.util.List;

public interface ITableService {
    /**
     * 查询数据库表信息
     *
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    public List<TableInfo> selectTableList(TableInfo tableInfo);
}
