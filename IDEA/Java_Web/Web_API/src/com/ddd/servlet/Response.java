package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("111111111111111111111");
        /*设置响应状态码302，表示重定向，（已搬迁）*/
//        resp.setStatus(302);
//        /*设置新的地址在哪*/
//        resp.setHeader("Location","http://localhost:8080/Web_API_war_exploded/response2");
        resp.sendRedirect("http://localhost:8080/Web_API_war_exploded/response2");

    }
}
