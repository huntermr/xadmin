package com.xadmin.support.core.exception;

import com.xadmin.framework.exception.BaseException;
import com.xadmin.support.core.constants.ArticleErrorCode;

public class ArticleException extends BaseException {

    public ArticleException(int status) {
        super(ArticleErrorCode.fromValue(status), status);
    }
}