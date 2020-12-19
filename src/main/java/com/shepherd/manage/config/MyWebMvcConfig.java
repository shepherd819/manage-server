package com.shepherd.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 19:51
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {


    /**
     *@description: 注册拦截器
     *@author: chengxiong
     *@datatime: 2020/12/18 15:41
     *@param: [registry]
     *@return: void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
//        registration.addPathPatterns("/*") //所有路径都被拦截
//                .excludePathPatterns(
//                        "/user/login",
//                        "/index",
//                        "/*/*.html",
//                        "/*/*.js",
//                        "/*/*.css",
//                        "/*/*.png",
//                        "/*/*.woff",
//                        "/*/*.ttf"
//                );
    }

    /**
     *@description: 不拦截静态资源
     * SpringBoot中默认以下5个位置可以存放静态资源 5./表示webapp目录SpringBoot默认没有此目录，
     * 用户可以自己建，优先级按下面的顺序
     * 1.classpath:/META-INF/resources/
     * 2.classpath:/resources/
     * 3.classpath:/static/
     * 4.classpath:/public/
     * 5./
     *@author: chengxiong
     *@datatime: 2020/12/18 15:42
     *@param: [registry]
     *@return: void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("/myStaticResourceLocation");//自定义静态资源位置
//          registry.addResourceHandler("/js/**").addResourceLocations("/");
//          registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//          registry.addResourceHandler("/html/**").addResourceLocations("/html/");
    }
}

