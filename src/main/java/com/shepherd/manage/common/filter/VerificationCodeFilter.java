package com.shepherd.manage.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherd.manage.common.ResBean;
import com.shepherd.manage.common.Result;
import com.shepherd.manage.common.constant.RetCodeConst;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 19:27
 */
@Component
public class VerificationCodeFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if ("POST".equals(request.getMethod())&&"/user/login".equals(request.getRequestURI())) {
            String verify_code = (String) request.getSession().getAttribute("verify_code");
            String code = (String) request.getParameter("code");
            if(code==null||verify_code==null ||!code.toLowerCase().equals(verify_code.toLowerCase())){
                //验证码错误
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                ResBean resBean = new ResBean();
                resBean.setRetCode(RetCodeConst.VERIFY_ERR_CODE);
                resBean.setRetInfo(RetCodeConst.VERIFY_ERR_MSG);
                new ObjectMapper().writeValue(writer,resBean);
//                writer.write(new ObjectMapper().writeValueAsString(Result.getResult(resBean)));
                writer.flush();
                writer.close();
            }else{
                filterChain.doFilter(request,response);
            }
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
