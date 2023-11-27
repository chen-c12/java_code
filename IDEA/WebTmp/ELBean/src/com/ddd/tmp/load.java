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
 * @author 金鱼
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
                        System.out.println("表单值name是："+item.getFieldName());
                        System.out.println("表单值value是"+item.getString());
                    }else {
                        System.out.println("表单值name是："+item.getFieldName());
                        System.out.println("文件名为："+item.getName());
                        item.write(new File("D://Tmp//tmp//"+item.getName()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
