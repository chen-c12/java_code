package com.ddd.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author ����
 * @title: response
 * @projectName chen
 * @description: TODO
 * @date 2022/1/189:45
 */
@Controller
public class response {
    @RequestMapping("/response_download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //��ȡServletContext����
        ServletContext servletContext = session.getServletContext();
        //��ȡ���������ļ�����ʵ·��
        String realPath = servletContext.getRealPath("/static/img/1.png");
        //����������
        InputStream is = new FileInputStream(realPath);
        //�����ֽ�����
        byte[] bytes = new byte[is.available()];
        //���������ֽ�������
        is.read(bytes);
        //����HttpHeaders����������Ӧͷ��Ϣ
        MultiValueMap<String, String> headers = new HttpHeaders();
        //����Ҫ���ط�ʽ�Լ������ļ�������
        headers.add("Content-Disposition", "attachment;filename=1.png");
        //������Ӧ״̬��
        HttpStatus statusCode = HttpStatus.OK;
        //����ResponseEntity����
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, statusCode);
        //�ر�������
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testresponse")
    public String download(){
        return "download";
    }

    @RequestMapping("/testup")
    public String upload(@RequestParam("photos") MultipartFile photo,HttpSession session) throws IOException {
        //��ȡ�ϴ����ļ����ļ���
        String fileName = photo.getOriginalFilename();
        //�����ļ���������
        /*UUID�����������*/
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //��ȡ��������photoĿ¼��·��
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        /*File.separator�ָ���*/
        String finalPath = photoPath + File.separator + fileName;
        //ʵ���ϴ�����
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
