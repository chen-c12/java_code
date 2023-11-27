package com.ddd.servlet;

import com.ddd.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 金鱼
 * @title: CookiesServlet
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/89:13
 */
public class CookiesServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key", "value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie创建成功！！");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getNmae返回Cookie的key
            //getValue返回Cookie的value
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }
        Cookie iwantCookie = CookieUtils.findCookie("key", cookies);

        //如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iwantCookie != null) {
            resp.getWriter().write("找到了需要的cookie");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("key", "value11");
//        //通知客户端保存修改
//        resp.addCookie(cookie);
//        resp.getWriter().write("key已经修改好了");

        Cookie cookie = CookieUtils.findCookie("key", req.getCookies());
        if (cookie != null) {
            cookie.setValue("newValue");
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key已经修改好了");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("defultLife", "defultLife");
        //设置存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到你要删除的Cookie对象
        Cookie cookie = new Cookie("key3", "values");
        //调用setMaxAge(0);
        if (cookie != null) {
            //马上删除Cookie
            cookie.setMaxAge(0);
            //调用response.addCookie(cookie)
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key3的cookie已经被删除");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        //设置cookie一小时后被删除
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }
}
