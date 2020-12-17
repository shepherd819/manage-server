package com.shepherd.manage.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.shepherd.manage.common.constant.RetCodeConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 12:44
 */
public class Result {

    private static final Logger log = LogManager.getLogger(Result.class);

    /**
     *@description: 无返回体
     *@author: chengxiong
     *@datatime: 2020/8/27 17:41
     *@param: [reCode, reInfo]
     *@return: java.lang.String
     */
    public static String getResult(String reCode, String reInfo) {
        JSONObject returnJson = new JSONObject();
        returnJson.put("reCode", reCode);
        returnJson.put("reInfo", reInfo);
        String returnStr = returnJson.toString();
        log.debug("接口返回结果为：" + returnStr);
        return returnStr;
    }

    /**
     *@description: 返回成功无返回体
     *@author: chengxiong
     *@datatime: 2020/8/27 17:40
     *@param: []
     *@return: java.lang.String
     */
    public static String getResultWithNoBody() {
        return getResult(RetCodeConst.SUCCESS_CODE, RetCodeConst.SUCCESS_MSG);
    }



}
