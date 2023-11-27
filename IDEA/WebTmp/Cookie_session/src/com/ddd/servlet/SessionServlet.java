package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 金鱼
 * @title: SessionServlet
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/814:45
 */
public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前Session会话，是否是新对话
        boolean aNew = session.isNew();
        //获取Session会话的唯一标识 id
        String id = session.getId();

        resp.getWriter().write("得到的Session它的id是" + id + "<br />");
        resp.getWriter().write("得到的Session是否是新创建的" + aNew + "<br />");
    }

    /**
     * 往session中保存数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("保存成功");


    }

    /**
     * 得到session中的数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取的key1数据是：" + attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认时长是：" + maxInactiveInterval);

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //设置当前session3秒超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //让session会话马上超时
        session.invalidate();
        resp.getWriter().write("session已经设置为超时（无效）");
    }
}
