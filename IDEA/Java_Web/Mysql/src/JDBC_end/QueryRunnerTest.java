package JDBC_end;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ddd
 * @title: QueryRunnerTest
 * @projectName Java_Web
 * @description:
 * @date 2021/9/2116:03
 */
public class QueryRunnerTest {

    @Test
    //插入
    public void testInsert() {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";

            int chencc = queryRunner.update(connection3, sql, "chencc", "203929302@qq.com", "2001-2-12");
            System.out.println(chencc);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mysqldriver.closeResource(connection3,null);
        }
    }
    //查询操作
    @Test
    //BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录
    public void testQuery1() throws Exception {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
            Customer query = queryRunner.query(connection3, sql, handler, 3);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqldriver.closeResource(connection3,null);
        }

    }

    @Test
    //BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录
    public void testQuery2() throws Exception {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> beanListHandler = new BeanListHandler<Customer>(Customer.class);
            List<Customer> query = queryRunner.query(connection3, sql, beanListHandler, 20);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqldriver.closeResource(connection3,null);
        }
    }

    @Test
    //MapHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录
    //减字段及相应字段的值作为map中的key和value
    public void testQuery3() throws Exception {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> query = queryRunner.query(connection3, sql, mapHandler, 3);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqldriver.closeResource(connection3,null);
        }

    }
    @Test
    //MapListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录
    public void testQuery4() throws Exception {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> query = queryRunner.query(connection3, sql, mapListHandler, 20);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqldriver.closeResource(connection3,null);
        }
    }

    @Test
    //ScalarHandler用于查询特殊值
    public void testQuery5() throws Exception {
        Connection connection3 = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection3 = mysqldriver.getConnection3();
            String sql = "select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();
            Object query = queryRunner.query(connection3, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqldriver.closeResource(connection3,null);
        }
    }
}
