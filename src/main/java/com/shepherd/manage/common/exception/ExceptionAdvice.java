package com.shepherd.manage.common.exception;


import com.shepherd.manage.common.Result;
import com.shepherd.manage.common.constant.RetCodeConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/8/27 17:15
 */
@ControllerAdvice
public class ExceptionAdvice {
    private static final Logger log = LogManager.getLogger(ExceptionAdvice.class);


    /**
     *@description:
     *@author: chengxiong
     *@datatime: 2020/8/27 17:16
     *@param: [ex, request, response, handler]
     *@return: java.lang.String
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response, Object handler){
        log.warn("发生未知异常！！！"+ex.getMessage(),ex);
        return Result.getResult(RetCodeConst.SYS_ERR_CODE,RetCodeConst.SYS_ERR_MSG);
    }

    /**
     * 拦截捕捉自定义异常 BaseException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public String baseErrorHandler(BaseException ex, HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.warn("发生异常了！！！"+ex.getMessage(), ex);
        //错误日志的记录，mq记录
        return Result.getResult(ex.getErrorCode(),ex.getMessage());
    }
}
