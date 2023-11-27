package com.chenddd.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author: chenddd
 * Date: 2022/4/12 14:53
 * FileName: MyLogoutSuccessHandler
 * Description: 自定义注销成功处理器
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "注销成功");
        map.put("status", 200);
        response.setContentType("application/json; charset=UTF-8");
        String string = new ObjectMapper().writeValueAsString(map);
        response.getWriter().println(string);
    }
}
