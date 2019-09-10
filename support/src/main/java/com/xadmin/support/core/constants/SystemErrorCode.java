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
public enum SystemErrorCode {
    SYSTEM_PARAM_CANNOT_DELETE_ERROR(22000, "系统参数不可删除"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    SystemErrorCode(Integer code, String desc) {
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
        for (SystemErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
