package com.chenddd.mybatisplus;

import com.chenddd.mybatisplus.mapper.UserMapper;
import com.chenddd.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Author: chenddd
* Date: 2022/4/4 21:09
* FileName: MybatisPlusTest
* Description: MybatisPlusTest
*/
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，如果没有条件设置null为参数
        List<User> users = userMapper.selectList(null);
       users.forEach(System.out::println);
    }


    @Test
    public void testInsert(){
        User user = new User(null, "张三", 14, "chenddd.@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
        System.out.println("id:"+user.getId());
    }

    @Test
    public void testDelete(){
        //通过id删除数据
        /*int result = userMapper.deleteById(1511015621296766977L);
        System.out.println("result:"+result);*/
        //通过map删除数据
       /* HashMap<String,Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);*/
       //通过id批量删除
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }

    @Test
    public void testupdate(){
        User user = new User(4L, "chenddd", 24, "chenddd@qq.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
        List<Integer> user = Arrays.asList(1, 2, 3, 4);
        List<User> users = userMapper.selectBatchIds(user);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(2L);
        System.out.println(map);
    }
}
