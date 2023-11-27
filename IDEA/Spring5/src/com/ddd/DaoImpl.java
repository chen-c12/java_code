package com.ddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Н№гу
 * @title: Dao
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2716:18
 */
@Repository
public class DaoImpl implements Dao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void reduceMoney() {
        String sql = "update momey set momey=momey-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    @Override
    public void addMoney() {
        String sql = "update momey set momey=momey+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }
}
