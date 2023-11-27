package com.chenddd.security.dao;

import com.chenddd.security.entity.Role;
import com.chenddd.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: chenddd
 * Date: 2022/4/14 16:14
 * FileName: UserDao
 * Description:
 */
@Mapper
@Repository
public interface UserDao {
    //根据用户名返回用户方法
    User loadUserByUsername(String name);


    List<Role> getRolesByUid(Integer uid);
}
