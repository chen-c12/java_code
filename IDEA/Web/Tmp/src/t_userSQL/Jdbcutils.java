package t_userSQL;

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

    static {
        Properties properties = new Properties();
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("t_userSQL/t_user.properties");
        InputStream is = Jdbcutils.class.getClassLoader().getResourceAsStream("t_userSQL/t_user.properties");

        try {
            properties.load(is);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection conn() throws SQLException {
        Connection connection = source.getConnection();
        return connection;
    }

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
}
