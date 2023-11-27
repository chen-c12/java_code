package com.chenddd.mail.email;

import com.chenddd.mail.entity.OnlyMail;
import com.chenddd.mail.service.OnlyMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: chenddd
 * Date: 2022/10/25 14:39
 * FileName: SendEmail
 * Description:
 */
@Component
public class SendEmail {
    @Resource
    JavaMailSender javaMailSender;


    @Value("${spring.mail.username}")
    private String emailSender;
    @Value("${sendto.email}")
    private String mailNumber;
    @Resource
    private OnlyMailService onlyMailService;


    /**
     *@author chenddd
     * 邮件的发送
     */
    public void sendMails(Long id){
        //创建简单邮件消息
        SimpleMailMessage message=new SimpleMailMessage();
        //邮件标题
        OnlyMail onlyMail = onlyMailService.selectMailMsgById(id);
        message.setSubject(onlyMail.getTitle());
        //邮件内容
        message.setText(onlyMail.getMessage());
        //谁发的
        message.setFrom(emailSender);
        //谁要接收 email chenddd2022@163.com
        //发给谁
        message.setTo(mailNumber);
        //发送
        javaMailSender.send(message);
        }

    public Boolean sendMail(Long id){
        //创建简单邮件消息
        SimpleMailMessage message=new SimpleMailMessage();
        //邮件标题
        OnlyMail onlyMail = onlyMailService.selectMailMsgById(id);
        if (StringUtils.hasText(onlyMail.getTitle())){
            message.setSubject(onlyMail.getTitle());
        }else {
            return false;
        }
        //邮件内容
        if (StringUtils.hasText(onlyMail.getMessage())) {
            message.setText(onlyMail.getMessage());
        }else {
            return false;
        }
        //谁发的
        message.setFrom(emailSender);
        //谁要接收 email chenddd2022@163.com
        //发给谁
        message.setTo(mailNumber);
        //发送
        javaMailSender.send(message);

        return true;
    }
}
