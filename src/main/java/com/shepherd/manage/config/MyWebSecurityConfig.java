package com.shepherd.manage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherd.manage.common.ResBean;
import com.shepherd.manage.common.constant.RetCodeConst;
import com.shepherd.manage.common.filter.VerificationCodeFilter;
import com.shepherd.manage.user.service.impl.MbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 12:39
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MbUserServiceImpl userService;

    @Autowired
    private VerificationCodeFilter verificationCodeFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/user/verifyCode");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/role/**").hasRole("admin")
//                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/user/login")
                .successHandler((req, resp, auth) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = resp.getWriter();
                    ResBean resBean = new ResBean();
                    resBean.setResult(auth.getPrincipal());
                    new ObjectMapper().writeValue(writer,resBean);
//                    writer.write(new ObjectMapper().writeValueAsString(auth.getPrincipal()));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((req, resp, ex) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = resp.getWriter();
                    ResBean resBean = new ResBean();
                    resBean.setRetCode(RetCodeConst.HINT_CODE);
                    resBean.setRetInfo(RetCodeConst.USERNAME_PASSWORD_ERR_MSG);
                    new ObjectMapper().writeValue(writer,resBean);
//                    writer.write(new ObjectMapper().writeValueAsString("用户名或密码错误"));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, resp, auth) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = resp.getWriter();
                    ResBean resBean = new ResBean();
                    new ObjectMapper().writeValue(writer,resBean);
//                    writer.write(new ObjectMapper().writeValueAsString("注销登录成功"));
                    writer.flush();
                    writer.close();
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, ex) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //未认证
                    PrintWriter writer = resp.getWriter();
                    ResBean resBean = new ResBean();
                    resBean.setRetCode(RetCodeConst.HINT_CODE);
                    resBean.setRetInfo(RetCodeConst.UNAUTHORIZED_MSG);
                    new ObjectMapper().writeValue(writer,resBean);
//                    writer.write(new ObjectMapper().writeValueAsString("未认证请登录"));
                    writer.flush();
                    writer.close();
                })
                .and()
                .csrf().disable();
    }
}
