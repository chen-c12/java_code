package com.chen.spring5.Dao.Impl;

import com.chen.spring5.Dao.UserDao;
import com.chen.spring5.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Н№гу
 * @title: UserDaoImpl
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2117:56
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {

        String sql = "insert into user values(?,?,?)";
        Object[] args = {null,user.getUser(),user.getPassword()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from user where id = ?";
        int i = jdbcTemplate.update(sql, id);
        System.out.println(i);

    }

    @Override
    public void update(User user) {
        String sql = "update user set user=?,password=? where id = ?";
        Object[] args = {user.getUser(),user.getPassword(),user.getId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public int selecta() {
        String sql = "select count(*) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;

    }

    @Override
    public User select(String id) {
        String sql = "select user,password from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public List<User> list() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public void batch(List<Object[]> batches) {
        String sql = "insert into user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batches);
        System.out.println(Arrays.toString(ints));
    }


}
