package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在servlet2（柜台2）中查看参数（材料）："+username);

        Object key = req.getAttribute("key");
        if (key==null){
            System.out.println("输入有误");
        }else if (key.equals("柜台1的章")){
            System.out.println("Servlet2处理自己的业务");
        }

//        System.out.println("Servlet2处理自己的业务");
    }
}
