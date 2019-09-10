package com.xadmin.admin.enums;

/**
 * 操作类型
 */
public enum OpType
{
    INSERT("新增"),
    EDIT("编辑"),
    DEL("删除"),
    EXPORT("导出"),
    IMPORT("导入"),
    OTHER("其它"),
    ;

    private String type;

    OpType(String type) {
        this.type = type;
    }
}
