package com.ddd.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author ����
 * @title: download
 * @projectName WebTmp
 * @description: �ļ�����
 * @date 2021/10/2816:30
 */
public class download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.��ȡҪ���ص��ļ�����
        String downloadFileName = "1.png";
        //2.��ȡҪ���ص��ļ����ݣ�ͨ��ServletContext������Զ�ȡ��
        ServletContext servletContext = getServletContext();
        //��ȡҪ���ص��ļ�����
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("�����ļ�����"+mimeType);
        //4.�ڻش�ǰ��ͨ����Ӧͷ���߿ͻ��˷��ص���������
        resp.setContentType(mimeType);
        //5.��Ҫ���߿ͻ����յ�����������������ʹ�ã�����ʹ����Ӧͷ��
        //Content-Disposition��Ӧͷ����ʾ�յ���������ô����
        //attachment��ʾ����
        // �ж��Ƿ��ǻ�������
        String ua = req.getHeader("User-Agent");
        if (ua.contains("Firefox")) {
        // ʹ������ĸ�ʽ���� BASE64 �����
            String str = "attachment; fileName=" + "=?utf-8?B?"
                    + new BASE64Encoder().encode("����.jpg".getBytes("utf-8")) + "?=";
        // ���õ���Ӧͷ��
            resp.setHeader("Content-Disposition", str);
        } else {
        // ������������ UTF-8 ���������
            String str = "attachment; fileName=" + URLEncoder.encode("����.jpg", "UTF-8");
        // Ȼ��ѱ������ַ������õ���Ӧͷ��
            resp.setHeader("Content-Disposition", str);
        }
        /*
        * /б�ܱ�������������ʾ��ַΪ:http://ip:port/������/    ӳ�� �������webĿ¼
        * */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //��ȡ��Ӧ�������
        OutputStream outputStream = resp.getOutputStream();
        //3.�����ص��ļ����ݻش����ͻ���
        //��ȡ��������ȫ�������ݣ�����������
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
