package com.ddd;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: DaoServiceTest
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2716:32
 */
public class DaoServiceTest {

    @Test
    public void accountMoney() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        DaoService daoUservice = context.getBean("daoService", DaoService.class);
        daoUservice.accountMoney();
    }
}