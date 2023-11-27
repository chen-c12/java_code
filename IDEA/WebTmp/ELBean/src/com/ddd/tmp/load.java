package com.ddd.tmp;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ����
 * @title: load
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/298:31
 */
public class load extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)){
            FileItemFactory itemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
            try{
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem item : list) {
                    if (item.isFormField()){
                        System.out.println("��ֵname�ǣ�"+item.getFieldName());
                        System.out.println("��ֵvalue��"+item.getString());
                    }else {
                        System.out.println("��ֵname�ǣ�"+item.getFieldName());
                        System.out.println("�ļ���Ϊ��"+item.getName());
                        item.write(new File("D://Tmp//tmp//"+item.getName()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
