package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========doGet=========");
       is(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==========doPost===========");
        /*设置请求字体为UTF-8*/
        req.setCharacterEncoding("UTF-8");
        is(req);
    }
    void is(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");


        System.out.println("用户名："+username);
        System.out.println("密码:"+password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));
    }
}
