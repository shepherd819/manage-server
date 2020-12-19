package com.shepherd.manage.common.constant;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 12:29
 */
public class RetCodeConst {
    public static String SUCCESS_CODE = "200";
    public static String SUCCESS_MSG = "成功";
    public static final String SYS_ERR_CODE = "500";//系统异常
    public static final String SYS_ERR_MSG = "呜呜出错了，请联系客服吧~</br>客服电话：19956593318";
    public static final String HINT_CODE = "1001";//提示级异常,前端弹出提示信息
    public static final String VERIFY_ERR_CODE = "1002";//验证码错误
    public static final String VERIFY_ERR_MSG = "验证码错误";

    public static final String USERNAME_PASSWORD_ERR_MSG = "用户名或密码错误";
    public static final String LOGOUT_SUCCESS_MSG = "注销登录成功";
    public static final String UNAUTHORIZED_MSG = "该接口需要登录";

}
