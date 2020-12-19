package com.shepherd.manage.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/html/v1/login")
    public String login(){
        System.out.println("aaa");
        return "aaa";
    }
}
