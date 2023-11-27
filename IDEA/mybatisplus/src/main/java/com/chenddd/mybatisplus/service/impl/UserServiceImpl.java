package com.chenddd.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenddd.mybatisplus.mapper.UserMapper;
import com.chenddd.mybatisplus.pojo.User;
import com.chenddd.mybatisplus.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* Author: chenddd
* Date: 2022/4/5 14:57
* FileName: UserServiceImpl
* Description: 
*/
@DS("master")//指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
