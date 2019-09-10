package com.xadmin.framework.handler;

import com.xadmin.framework.constants.CoreErrorCode;
import com.xadmin.framework.exception.BaseException;
import com.xadmin.framework.vo.ResponseVo;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public ResponseVo baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
//        response.setStatus(200);
        return new ResponseVo(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseVo exceptionHandler(HttpServletResponse response, Exception ex) {
        logger.error(ex.getMessage(),ex);
        return new ResponseVo(CoreErrorCode.SYSTEM_ERROR.getCode(), CoreErrorCode.SYSTEM_ERROR.getDesc());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseVo methodNotSupportedExceptionHandler(HttpServletResponse response, HttpRequestMethodNotSupportedException ex) {
        logger.error("不支持当前请求方式" + ex.getMessage(),ex);
        return new ResponseVo(CoreErrorCode.METHOD_NOT_SUPPORTED_ERROR.getCode(), CoreErrorCode.METHOD_NOT_SUPPORTED_ERROR.getDesc());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVo handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder errorMesssage = new StringBuilder("参数校验异常:");

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage.append(fieldError.getDefaultMessage());
        }
        logger.error("参数校验异常", ex);
        return new ResponseVo(CoreErrorCode.PARAM_ERROR.getCode(), errorMesssage.toString());
    }

    @ExceptionHandler(BindException.class)
    public ResponseVo handleBindException(HttpServletRequest request, BindException ex) {
        StringBuilder errorMesssage = new StringBuilder("参数校验异常:");

        for (FieldError fieldError : ex.getFieldErrors()) {
            errorMesssage.append(fieldError.getDefaultMessage());
        }

        logger.error("参数校验异常", ex);
        return new ResponseVo(CoreErrorCode.PARAM_ERROR.getCode(), errorMesssage.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseVo missingServletRequestParameterExceptionHandler(HttpServletResponse response, MissingServletRequestParameterException ex) {
        logger.error("必填参数为空",ex);
        return new ResponseVo(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode(), CoreErrorCode.REQUIRED_PARAM_EMPTY.getDesc());
    }

    @ExceptionHandler(ShiroException.class)
    public ResponseVo handleShiroException(HttpServletRequest request, ShiroException ex) {
        logger.error("未授权的访问", ex);
        return new ResponseVo(CoreErrorCode.SYSTEM_AUTH_ERROR.getCode(), CoreErrorCode.SYSTEM_AUTH_ERROR.getDesc());
    }
}