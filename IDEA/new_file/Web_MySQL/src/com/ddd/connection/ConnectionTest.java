package com.ddd.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testconnection() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver() ;

        String url = "jdbc:mysql://localhost:3306/zs";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }
}
