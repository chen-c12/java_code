package com.ddd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ����
 * @title: SessionServlet
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/814:45
 */
public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //�����ͻ�ȡSession�Ự����
        HttpSession session = req.getSession();
        //�жϵ�ǰSession�Ự���Ƿ����¶Ի�
        boolean aNew = session.isNew();
        //��ȡSession�Ự��Ψһ��ʶ id
        String id = session.getId();

        resp.getWriter().write("�õ���Session����id��" + id + "<br />");
        resp.getWriter().write("�õ���Session�Ƿ����´�����" + aNew + "<br />");
    }

    /**
     * ��session�б�������
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("����ɹ�");


    }

    /**
     * �õ�session�е�����
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("��session�л�ȡ��key1�����ǣ�" + attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session��Ĭ��ʱ���ǣ�" + maxInactiveInterval);

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //�Ȼ�ȡSession����
        HttpSession session = req.getSession();
        //���õ�ǰsession3�볬ʱ
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("��ǰsession�Ѿ�����3���ʱ");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //��session�Ự���ϳ�ʱ
        session.invalidate();
        resp.getWriter().write("session�Ѿ�����Ϊ��ʱ����Ч��");
    }
}
