package com.shepherd.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shepherd.manage.*.mapper")
@SpringBootApplication
public class ManageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageServerApplication.class, args);
    }

}
