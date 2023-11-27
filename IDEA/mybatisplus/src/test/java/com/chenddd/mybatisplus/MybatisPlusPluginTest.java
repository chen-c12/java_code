package com.chenddd.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenddd.mybatisplus.mapper.UserMapper;
import com.chenddd.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* Author: chenddd
* Date: 2022/4/6 15:37
* FileName: MybatisPlusPluginTest
* Description: 
*/
@SpringBootTest
public class MybatisPlusPluginTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
        System.out.println(page);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());
    }

    @Test
    public void testSelectPageVo(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page,20);
        System.out.println(page);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());
    }
}
