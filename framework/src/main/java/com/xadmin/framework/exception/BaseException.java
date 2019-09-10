package com.xadmin.framework.exception;

import com.xadmin.framework.constants.CoreErrorCode;

public class BaseException extends RuntimeException {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BaseException() {
        this(CoreErrorCode.SYSTEM_ERROR.getCode());
    }

    public BaseException(int status) {
        this(CoreErrorCode.fromValue(status), status);
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }
}