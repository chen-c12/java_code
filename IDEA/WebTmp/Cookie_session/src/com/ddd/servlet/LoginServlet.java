package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ����
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
            //��¼�ɹ�
            Cookie cookie = new Cookie("username", username);
            //cookieһ������Ч
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            System.out.println("��½�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }


    }
}
