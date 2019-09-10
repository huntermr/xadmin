package com.xadmin.support.core.exception;

import com.xadmin.framework.exception.BaseException;
import com.xadmin.support.core.constants.UserErrorCode;

public class UserException extends BaseException {

    public UserException(int status) {
        super(UserErrorCode.fromValue(status), status);
    }
}