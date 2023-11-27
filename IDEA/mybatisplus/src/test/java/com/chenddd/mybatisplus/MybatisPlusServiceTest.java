package com.chenddd.mybatisplus;

/**
* Author: chenddd
* Date: 2022/4/5 15:00
* FileName: MybatisPlusServiceTest
* Description: 
*/

import com.chenddd.mybatisplus.pojo.User;
import com.chenddd.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 统计总信息数
     */
    @Test
    public void testUserCount(){
        long count = userService.count();
        System.out.println("总记录数："+count);
    }

    /**
     * 查询所有信息
     */
    @Test
    public void testUserList(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

    /**
     * 批量添加
     */
    @Test
    public void test(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            String random = UUID.randomUUID().toString().substring(0, 5);
            user.setName("ch"+random);
            user.setAge(i);
            user.setEmail(random+"@chen.com");
            list.add(user);
        }

        boolean saveBatch = userService.saveBatch(list);
        System.out.println(saveBatch);
    }
}
