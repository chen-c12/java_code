package com.chen.spring5.Dao;

import com.chen.spring5.domain.User;

import java.util.List;

/**
 * @author Н№гу
 * @title: UserDao
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2117:52
 */
public interface UserDao {
    void add(User user);

    void delete(String id);

    void update(User user);

    int selecta();

    User select(String id);

    List<User> list();

     void batch(List<Object[]> batches);
}
