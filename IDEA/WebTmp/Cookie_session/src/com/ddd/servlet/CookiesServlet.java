package com.ddd.servlet;

import com.ddd.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ����
 * @title: CookiesServlet
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/89:13
 */
public class CookiesServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.����Cookie����
        Cookie cookie = new Cookie("key", "value1");
        //2.֪ͨ�ͻ��˱���Cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie�����ɹ�����");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getNmae����Cookie��key
            //getValue����Cookie��value
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }
        Cookie iwantCookie = CookieUtils.findCookie("key", cookies);

        //���������null��˵������ֵ��Ҳ�����ҵ�����Ҫ��Cookie
        if (iwantCookie != null) {
            resp.getWriter().write("�ҵ�����Ҫ��cookie");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("key", "value11");
//        //֪ͨ�ͻ��˱����޸�
//        resp.addCookie(cookie);
//        resp.getWriter().write("key�Ѿ��޸ĺ���");

        Cookie cookie = CookieUtils.findCookie("key", req.getCookies());
        if (cookie != null) {
            cookie.setValue("newValue");
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key�Ѿ��޸ĺ���");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("defultLife", "defultLife");
        //���ô��ʱ��
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //���ҵ���Ҫɾ����Cookie����
        Cookie cookie = new Cookie("key3", "values");
        //����setMaxAge(0);
        if (cookie != null) {
            //����ɾ��Cookie
            cookie.setMaxAge(0);
            //����response.addCookie(cookie)
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key3��cookie�Ѿ���ɾ��");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        //����cookieһСʱ��ɾ��
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("�Ѿ�������һ�����һСʱ��cookie");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //�õ�����·��
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("������һ������Path·����Cookie");
    }
}
