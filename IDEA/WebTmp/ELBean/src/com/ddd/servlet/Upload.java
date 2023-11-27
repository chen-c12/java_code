package com.ddd.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ???
 * @title: Upload
 * @projectName WebTmp
 * @description: �ļ��ϴ�
 * @date 2021/10/2723:04
 */
public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] buffer = new byte[1024000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer,0,read));

//        1.�ж��ϴ��������Ƿ������ݣ�ֻ�ж�����ݣ������ļ��ϴ���

        if (ServletFileUpload.isMultipartContent(req)){
            //����FileItemFactory����ʵ����
            FileItemFactory itemFactory = new DiskFileItemFactory();
            // �������ڽ����ϴ����ݵĹ����� ServletFileUpload ��
            ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
            servletFileUpload.setHeaderEncoding("utf-8");
            try {
                // �����ϴ������ݣ��õ�ÿһ������ FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // ѭ���жϣ�ÿһ���������ͨ���ͣ������ϴ����ļ�
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //�ж��ǲ�����ͨ��
                        System.out.println("�����name����ֵ��" + fileItem.getFieldName());
                        //����utf-8�������������
                        System.out.println("�����value����ֵ��" + fileItem.getString("UTF-8"));
                    } else {
                        //�ϴ��ļ�
                        System.out.println("�����name����ֵ��" + fileItem.getFieldName());
                        System.out.println("�ϴ����ļ�����" + fileItem.getName());

                        fileItem.write(new File("D:\\Tmp\\tmp\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();


            }
        }
    }
}
