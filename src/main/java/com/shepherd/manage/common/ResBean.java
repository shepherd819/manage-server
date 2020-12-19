package com.shepherd.manage.common;

/**
 * @Author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 22:11
 */
public class ResBean {
    private String retCode;
    private String retInfo;
    private Object result;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
