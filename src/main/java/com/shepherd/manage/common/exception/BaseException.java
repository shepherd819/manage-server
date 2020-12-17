package com.shepherd.manage.common.exception;

import com.shepherd.manage.common.constant.RetCodeConst;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 11:49
 */
public class BaseException extends RuntimeException{

    private String deafultErrCode = RetCodeConst.SYS_ERR_CODE;//默认的返回是系统异常

    private  boolean emailWarningFlag;//邮件告警标志

    public BaseException() {}

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String errorCode,String message) {
        super(message);
        this.deafultErrCode = errorCode;
    }
    public BaseException(String errorCode, String message, Throwable t) {
        super(message,t);
        this.deafultErrCode = errorCode;
    }

    public String getErrorCode() {
        return deafultErrCode;
    }

    public void setErrorCode(String errorCode) {
        this.deafultErrCode = errorCode;
    }
}
