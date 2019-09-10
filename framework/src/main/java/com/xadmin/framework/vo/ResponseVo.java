package com.xadmin.framework.vo;


import com.xadmin.framework.constants.CoreErrorCode;

/**
 * Created by Administrator on 2018/1/30.
 */
public class ResponseVo<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;

    public ResponseVo() {
        this.status = CoreErrorCode.SUCCESS.getCode();
        this.message = CoreErrorCode.SUCCESS.getDesc();
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseVo(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseVo(T data) {
        this.status = CoreErrorCode.SUCCESS.getCode();
        this.message = CoreErrorCode.SUCCESS.getDesc();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResponseVo<T> ok(){
        return new ResponseVo<>();
    }

    public static <T> ResponseVo<T> buildServerError(){
        return new ResponseVo<>(CoreErrorCode.SYSTEM_ERROR.getCode(), CoreErrorCode.SYSTEM_ERROR.getDesc());
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public long getTimestamp() {
        return this.timestamp;
    }


}