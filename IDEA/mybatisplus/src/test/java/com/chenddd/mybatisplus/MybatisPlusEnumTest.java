package com.chenddd.mybatisplus;

import com.chenddd.mybatisplus.enums.SexEnum;
import com.chenddd.mybatisplus.mapper.UserMapper;
import com.chenddd.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* Author: chenddd
* Date: 2022/4/7 10:43
* FileName: MybatisPlusEnumTest
* Description: 
*/
@SpringBootTest
public class MybatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSexEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
//设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
//INSERT INTO t_user ( username, age, sex ) VALUES ( ?, ?, ? )
//Parameters: Enum(String), 20(Integer), 1(Integer)
        userMapper.insert(user);
    }
}
