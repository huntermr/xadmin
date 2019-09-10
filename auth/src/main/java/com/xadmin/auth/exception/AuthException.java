package com.xadmin.auth.exception;

import com.xadmin.auth.constants.AuthErrorCode;
import com.xadmin.framework.exception.BaseException;

public class AuthException extends BaseException {

    public AuthException(int status) {
        super(AuthErrorCode.fromValue(status), status);
    }
}