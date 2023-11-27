package com.chenddd.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author: chenddd
 * Date: 2022/4/12 10:57
 * FileName: MySuccessHandler
 * Description: 自定义认证成功之后的处理
 */
public class MySuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "登陆成功");
        map.put("status", 200);
        map.put("authentication", authentication);
        response.setContentType("application/json;charset=UTF-8");
        String string = new ObjectMapper().writeValueAsString(map);
        response.getWriter().println(string);

    }
}
