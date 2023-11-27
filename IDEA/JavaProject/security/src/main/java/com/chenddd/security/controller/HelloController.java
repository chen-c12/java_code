package com.chenddd.security.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author: chenddd
 * Date: 2022/4/11 16:55
 * FileName: HelloController
 * Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) throws IOException {
        System.out.println("hello security");
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("身份", principal.getUsername());
        map.put("凭证", authentication.getCredentials());
        map.put("权限", authentication.getAuthorities());
        String string = new ObjectMapper().writeValueAsString(map);
        return "hello security";
    }
}
