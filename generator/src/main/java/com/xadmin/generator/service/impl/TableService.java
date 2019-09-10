package com.xadmin.generator.service.impl;

import com.xadmin.generator.entity.TableInfo;
import com.xadmin.generator.mapper.TableMapper;
import com.xadmin.generator.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService implements ITableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<TableInfo> selectTableList(TableInfo tableInfo) {
        return tableMapper.selectTableList(tableInfo);
    }
}
