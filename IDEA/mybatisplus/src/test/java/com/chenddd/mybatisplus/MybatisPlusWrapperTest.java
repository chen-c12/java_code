package com.chenddd.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.chenddd.mybatisplus.mapper.UserMapper;
import com.chenddd.mybatisplus.pojo.User;
import com.chenddd.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
* Author: chenddd
* Date: 2022/4/5 23:44
* FileName: MybatisPlusWrapperTest
* Description: 
*/
@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 多条件查询
     * SELECT id,name,age,email FROM user WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
     */
    @Test
    public void testqueryWrappers(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 排序功能
     * SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC
     */
    @Test
    public void testqWrapperOrderBy(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    /**
     * 删除例子
     * DELETE FROM user WHERE (email IS NULL)
     */
    @Test
    public void testWrapperDelete(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int delete = userMapper.delete(wrapper);
        System.out.println("删除："+delete);
    }

    /**
     * 使用QueryWrapper实现修改功能
     * UPDATE user SET name=?, email=? WHERE (age > ? AND name LIKE ? OR email IS NULL)
     */
    @Test
    public void testWrapperUpdate(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        User user = new User(null, "sdfgdfd", null, "chenddd@qq.com");
        int update = userMapper.update(user, wrapper);
        System.out.println("result："+update);
    }


    /**
     * 查询优先级例子
     *  UPDATE user SET name=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
     */
    @Test
    public void testWrapperUpdate2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User(null, "chedda", null, null);
        int update = userMapper.update(user, wrapper);
    }

    /**
     * 字段查询例子
     *  SELECT name,email,age FROM user
     */
    @Test
    public void testSelect(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","email","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 子查询例子
     * SELECT id,name,age,email FROM user WHERE (id IN (select id from user where id <= 100))
     */
    @Test
    public void testSelect1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from user where id <= 100");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 使用updateWrapper实现修改功能
     * UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
     */
    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        wrapper.set("name", "erjwkr").set("email", "cjemddd@qq.com");
        int update = userMapper.update(null, wrapper);
        System.out.println("result:"+update);
    }


    /**
     * 开发中组装条件情况
     * SELECT id,name,age,email FROM user WHERE (age BETWEEN ? AND ?)
     */
    @Test
    public void testUserInformations(){
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)){
            //isNotBlank判断某个字符串是否不为空字符串，不为null，不为空白符
            wrapper.like("name", name);
        }
        if (ageBegin != null && ageEnd != null){
            wrapper.between("age", ageBegin, ageEnd);
        }
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    /**
     * 使用condition
     */
    @Test
    public void testCondition(){
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name), "name", name)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 使用LambdaQueryWrapper
     * SELECT id,name,age,email FROM user WHERE (age >= ? AND age <= ?)
     */
    @Test
    public void testLambdaQueryWrapper(){
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name), User::getName,name)
                .ge(ageBegin!=null, User::getAge,ageBegin)
                .le(ageEnd !=null,User::getAge,ageEnd);

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void testLambdaUpadateWrapper(){
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName,"a")
                .and(i -> i.gt(User::getAge,20).isNull(User::getEmail));
        wrapper.set(User::getName,"chena").set(User::getEmail,"euwiqujew@qq.com");
    }

}
