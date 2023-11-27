package com.ddd.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在servlet1（柜台1）中查看参数（材料）："+username);
        req.setAttribute("key","柜台1的章");

        RequestDispatcher servlet2 = req.getRequestDispatcher("/servlet1");

        servlet2.forward(req,resp);

    }
}
