package com.shepherd.manage.unitTest;

import com.shepherd.manage.common.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 13:49
 */
public class RegexTest {

    @Test
    public void mobileNoTest(){
        Assert.assertTrue(StringUtil.isMobileNo("19956593318"));
        Assert.assertFalse(StringUtil.isMobileNo("11111111111"));
        Assert.assertTrue(StringUtil.isMobileNo("13145688795"));
        Assert.assertFalse(StringUtil.isMobileNo("8570778"));
        Assert.assertFalse(StringUtil.isMobileNo("13516651a66"));
        Assert.assertFalse(StringUtil.isMobileNo("135166511561"));

    }
}
