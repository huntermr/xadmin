/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.support.core.constants;

/**
 * Copyright (C), 2015-2019, xadmin
 * FileName: UserErrorCode
 * Author:   Ht
 * Date:     2019/1/31 15:28
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum UserErrorCode {
    USER_OR_PASSWORD_ERROR(20000, "用户名或密码错误"),
    USER_LOCK_ERROR(20001, "该用户已锁定"),
    USER_NOT_EXIST_ERROR(20002, "该用户不存在"),
    USER_NAME_EMPTY_ERROR(20003, "用户名不能为空"),
    USER_PASSWORD_EMPTY_ERROR(20004, "密码不能为空"),
    USER_NAME_EXIST_ERROR(20005, "该用户名已存在"),
    ROLE_NOT_EXIST_ERROR(20006, "该角色不存在"),
    ADMIN_USER_CANNOT_DELETE_ERROR(20007, "超级管理员不可删除"),
    ADMIN_UNWANT_ROLE_ERROR(20008, "超级管理员无需分配角色"),
    USER_GROUP_NOT_EXIST_ERROR(20009, "该用户组不存在"),
    RESOURCE_CHILD_NOT_EMPTY_ERROR(20010, "该资源含有下级资源,不可删除"),
    RESOURCE_PARENT_NOT_EXIST_ERROR(20011, "父类资源不存在"),
    RESOURCE_LEVEL_ERROR(20012, "不可选择下级作为父级分类"),
    RESOURCE_CANNOT_SELF_ERROR(20013, "父级分类不能为自己"),
    DEPT_PARENT_NOT_EXIST_ERROR(20014, "父类部门不存在"),
    DEPT_CANNOT_SELF_ERROR(20015, "父级部门不能为自己"),
    DEPT_LEVEL_ERROR(20012, "不可选择下级作为父级部门"),
    ADMIN_ROLE_CANNOT_DELETE_ERROR(20013, "管理员角色不可删除"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    UserErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static final String fromValue(int value) {
        for (UserErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
