package com.shepherd.manage.unitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 9:55
 */
public class JunitTestDemo {

    @Before
    public void beforeTest(){
        System.out.println("before test doSomething..");
    }
    @After
    public void afterTest(){
        System.out.println("after test doSomething..");
    }
    @Test
    public void doSomethingTest(){
        System.out.println("doSomething");
    }
}
