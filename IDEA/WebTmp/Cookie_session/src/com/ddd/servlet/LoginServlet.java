package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 金鱼
 * @title: LoginServlet
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/814:09
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("123".equals(username)&&"123456".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username", username);
            //cookie一周内有效
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            System.out.println("登陆成功");
        }else {
            System.out.println("登录失败");
        }


    }
}
