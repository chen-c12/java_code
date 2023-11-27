package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPI_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI===>>>"+req.getRequestURI());
        System.out.println("URL===>>>"+req.getRequestURL());
        System.out.println("客户端IP地址===>>>"+req.getRemoteHost());
        System.out.println("请求头部===>>>"+req.getHeader("User-Agent"));
        System.out.println("请求方式===>>>"+req.getMethod());
    }
}
