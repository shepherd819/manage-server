package com.shepherd.manage.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 10:53
 */
public class StringUtil {
    private static final Pattern CH_MOBILE_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
    private static final Pattern HK_MOBILE_PATTERN = Pattern.compile("^(5|6|8|9)\\d{7}$");
    private static final Pattern NUM_PATTERN = Pattern.compile("[0-9]+");

    /**
     *@description: 判断字符串是否为空（null或空串返回true）
     *@author: chengxiong
     *@datatime: 2020/12/17 10:54
     *@param: [str]
     *@return: boolean
     */
    public static boolean isEmpty(String str){
        return str==null || "".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     *@description: 判断是否为大陆手机号码
     *@author: chengxiong
     *@datatime: 2020/12/17 13:39
     *@param: [mobileNo]
     *@return: boolean
     */
    public static boolean isMobileNo(String mobileNo) {
        Matcher m = CH_MOBILE_PATTERN.matcher(mobileNo);
        return m.matches();
    }

    /**
     *@description: 判断是否香港手机号
     *@author: chengxiong
     *@datatime: 2020/12/17 14:01
     *@param: [mobileNo]
     *@return: boolean
     */
    public static boolean isHKMobileNo(String mobileNo){
        Matcher m = HK_MOBILE_PATTERN.matcher(mobileNo);
        return m.matches();
    }

    /**
     *@description: 判断是否正整数
     *@author: chengxiong
     *@datatime: 2020/12/17 14:01
     *@param: [numStr]
     *@return: boolean
     */
    public static boolean isNumeric(String numStr) {
        Matcher m = NUM_PATTERN.matcher(numStr);
        return m.matches();
    }

}
