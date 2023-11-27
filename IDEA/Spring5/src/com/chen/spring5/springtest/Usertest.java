package com.chen.spring5.springtest;

import com.chen.spring5.Service.UserService;
import com.chen.spring5.domain.Book;
import com.chen.spring5.domain.Order;
import com.chen.spring5.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Н№гу
 * @title: Usertest
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2017:33
 */
public class Usertest {
    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopbean.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
//        user.setUser("111");
//        user.setPassword("122233");
//        userService.addUser(user);

//        List<User> list = userService.list();
//        System.out.println(list);

        List<Object[]> list = new ArrayList<>();
        Object[] q = {"6","ww","123456"};
        Object[] w = {"7","qq","123456"};
        list.add(q);
        list.add(w);
        userService.batch(list);
    }
}
