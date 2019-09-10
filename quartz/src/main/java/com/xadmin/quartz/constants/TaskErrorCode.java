/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.quartz.constants;

/**
 * Copyright (C), 2015-2019, xadmin
 * FileName: TaskErrorCode
 * Author:   Ht
 * Date:     2019/1/31 15:28
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum TaskErrorCode {
    TASK_EXIST_ERROR(20000, "该定时任务已存在"),
    TASK_NOT_EXIST_ERROR(20001, "该定时任务不存在"),
    TASK_PARAMS_ERROR(20002, "参数异常,请检查类名或表达式"),
    TASK_MISFIRE_ERROR(20003, "补偿机制非法,请检查"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    TaskErrorCode(Integer code, String desc) {
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
        for (TaskErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
