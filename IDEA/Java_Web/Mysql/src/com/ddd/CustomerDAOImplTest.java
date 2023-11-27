package com.ddd;

import JDBC_end.Customer;
import JDBC_end.mysqldriver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

public class CustomerDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void insert() {
        Connection conn = null;
        try {
            conn = mysqldriver.getConnection3();
            Customer customer = new Customer(1, "chen", "239229203", new Date(392033902L));
            dao.insert(conn,customer);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mysqldriver.closeResource(conn,null);
        }
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getCustomerById() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getCount() {
    }

    @Test
    public void getMaxBirth() {
    }
}