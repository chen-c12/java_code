package com.chen.spring5.AOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Н№гу
 * @title: Aoptest
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2517:00
 */
public class Aoptest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopbean.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }
}
