package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 金鱼
 * @title: Jdbcutils
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2515:16
 */
public class Jdbcutils {

    private static DataSource source;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        Properties properties = new Properties();
        /*InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("t_userSQL/t_user.properties");*/
        InputStream is = Jdbcutils.class.getClassLoader().getResourceAsStream("utils/t_user.properties");

        try {
            properties.load(is);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection conn() throws SQLException {

       Connection conn = conns.get();
       if (conn == null){
           try {
               //从数据库连接池中取
               conn = source.getConnection();
               //保存到ThreadLocal对象中，供后面的jdbc操作使用
               conns.set(conn);
               //设置为手动管理事物
               conn.setAutoCommit(false);
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null){
            //如果不等于null,说明之前使用过连接，操作过数据库
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错，（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null){
            //如果不等于null,说明之前使用过连接，操作过数据库
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错，（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }



    /*
    public static void closeResource(Connection conn, PreparedStatement ps){
        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */
}
