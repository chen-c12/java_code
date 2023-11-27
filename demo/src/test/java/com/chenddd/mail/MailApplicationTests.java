package com.chenddd.mail;

import com.chenddd.mail.common.Result;
import com.chenddd.mail.dao.OnlyMailDao;
import com.chenddd.mail.service.OnlyMailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MailApplicationTests {
    @Resource
    private OnlyMailService onlyMailService;

    @Test
    void contextLoads() {
    }

    @Test
    void selectMailAll(){
        Result result = onlyMailService.selectAll();
        System.out.println(result);
    }

    @Test
    void updateMail(){
    }
}
