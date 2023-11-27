package com.chen.spring5.springtest;

import com.chen.spring5.domain.Course;
import com.chen.spring5.domain.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: MapperTest
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/229:21
 */
public class MapperTest {
    @Test
    public void restMap(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("com/chen/spring5/bean/bean4.xml");
        Mapper mapper = context.getBean("mapper", Mapper.class);
        mapper.test();
    }

    @Test
    public void testCourse(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("com/chen/spring5/bean/bean1.xml");
        Course course = context.getBean("course", Course.class);
        System.out.println(course);
    }

}