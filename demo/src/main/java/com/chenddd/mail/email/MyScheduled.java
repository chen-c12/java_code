package com.chenddd.mail.email;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: chenddd
 * Date: 2022/10/25 13:45
 * FileName: MyScheduled
 * Description:
 */
//@Component
public class MyScheduled {
    @Resource
    private SendEmail sendEmail;


    @Scheduled(cron ="0 00 13 * * *")
    public void dayMail01(){
        System.out.println("执行了1");
        sendEmail.sendMails(new Long(1));
    }


    @Scheduled(cron ="0 01 13 * * *")
    public void dayMail02(){
        System.out.println("执行了2");
        sendEmail.sendMails(new Long(2));
    }


    @Scheduled(cron ="0 02 13 * * *")
    public void dayMail03(){
        sendEmail.sendMails(new Long(3));
    }


    @Scheduled(cron ="0 03 13 * * *")
    public void dayMail04(){
        sendEmail.sendMails(new Long(4));
    }


    @Scheduled(cron ="0 04 13 * * *")
    public void dayMail05(){
        sendEmail.sendMails(new Long(5));
    }



    @Scheduled(cron ="0 05 13 * * *")
    public void dayMail06(){
        sendEmail.sendMails(new Long(6));
    }


    @Scheduled(cron ="0 06 13 * * *")
    public void dayMail07(){
        sendEmail.sendMails(new Long(7));
    }


    @Scheduled(cron ="0 07 13 * * *")
    public void dayMail08(){
        sendEmail.sendMails(new Long(8));
    }

}

