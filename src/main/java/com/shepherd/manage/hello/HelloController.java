package com.shepherd.manage.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 13:26
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/admin/hello")
    public String admin(){
        return "admin/hello";
    }
    @GetMapping("/user/hello")
    public String user(){
        return "user/hello";
    }
    @PostMapping("/success")
    public String loginSuccess(){
        return "login success";
    }
}
