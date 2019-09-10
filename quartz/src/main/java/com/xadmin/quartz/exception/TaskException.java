package com.xadmin.quartz.exception;

import com.xadmin.framework.exception.BaseException;
import com.xadmin.quartz.constants.TaskErrorCode;

public class TaskException extends BaseException {

    public TaskException(int status) {
        super(TaskErrorCode.fromValue(status), status);
    }
}