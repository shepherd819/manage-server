package com.shepherd.manage.config;

import com.shepherd.manage.common.interceptors.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 19:51
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
        registration.addPathPatterns("/*") //所有路径都被拦截
        .excludePathPatterns(
                "/user/login",
                "/index",
                "/*/*.html",
                "/*/*.js",
                "/*/*.css",
                "/*/*.png",
                "/*/*.woff",
                "/*/*.ttf"
        );
    }
}

