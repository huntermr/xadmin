/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.auth.constants;

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
public enum AuthErrorCode {
    UNAUTH_ERROR(90000, "无权进行该操作"),
    TOKEN_ERROR(90001, "令牌非法,无权进行该操作"),
    AUTH_USER_NOT_EXIST_ERROR(90002, "无权限,用户不存在"),
    AUTH_USER_LOCK_ERROR(90003, "无权限,用户已锁定"),

    ;

    private final int code;
    private final String desc;

    AuthErrorCode(Integer code, String desc) {
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
        for (AuthErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
