package com.chen.spring5.springtest;

import com.chen.spring5.domain.Dog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: dogTest
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/228:50
 */
public class dogTest {

    @Test
    public void testdog() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/chen/spring5/bean/bean3.xml");
        Dog dog = context.getBean("dog", Dog.class);
        dog.testdog();
    }
}