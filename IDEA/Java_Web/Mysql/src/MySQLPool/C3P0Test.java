package MySQLPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @projectName Java_Web
 * @description: 数据库连接池C3P0测试
 * @author 金鱼
 * @date 2021/9/2015:32
 */

public class C3P0Test {
    @Test
    public void testGetConnection() throws Exception {
//        获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //loads the jdbc driver
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true&&useUnicode=true&characterEncoding=utf8" );
        cpds.setUser("root");
        cpds.setPassword("123456");
//        通过设置相关的参数对数据库连接池管理
//        设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);

        //销毁连接池
//        DataSources.destroy(cpds);
    }

    //方式二

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testConnection() throws SQLException {
        ComboPooledDataSource cpds1 = new ComboPooledDataSource("c3p0");
        Connection connection = cpds1.getConnection();
        System.out.println(connection);
    }

}
