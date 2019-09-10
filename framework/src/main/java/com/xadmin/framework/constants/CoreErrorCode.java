/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.framework.constants;

/**
 * Copyright (C), 2015-2019, xadmin
 * FileName: CoreErrorCode
 * Author:   Ht
 * Date:     2019/1/31 15:28
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum CoreErrorCode {
    SUCCESS(10000, "success"),

    // 9xxxx 系统错误时状态码(系统预留)
    SYSTEM_ERROR(99999, "系统错误"),
    REQUIRED_PARAM_EMPTY(99998, "必填参数为空"),
    METHOD_NOT_SUPPORTED_ERROR(99997, "不支持的请求方法"),
    PARAM_ERROR(99996, "参数校验异常,请检查"),
    DATA_NOT_EXIST_ERROR(99995, "数据不存在"),
    SYSTEM_AUTH_ERROR(99994, "无权限进行该操作"),
    SENTINEL_ERROR(99993, "服务器繁忙,请稍后再试"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    CoreErrorCode(Integer code, String desc) {
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
        for (CoreErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
