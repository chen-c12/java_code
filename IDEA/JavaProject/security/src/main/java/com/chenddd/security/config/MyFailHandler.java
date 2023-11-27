package com.chenddd.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author: chenddd
 * Date: 2022/4/12 14:15
 * FileName: MyFailHandler
 * Description: 自定义失败处理
 */
public class MyFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "登录失败");
        map.put("status", 500);
        map.put("exception", exception.getMessage());
        response.setContentType("application/json; charset=UTF-8");
        String string = new ObjectMapper().writeValueAsString(map);
        response.getWriter().println(string);
    }
}
