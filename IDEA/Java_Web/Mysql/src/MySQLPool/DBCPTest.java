package MySQLPool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title: DBCPTest
 * @projectName Java_Web
 * @description: DBCP的数据库连接池技术
 * @author 金鱼
 * @date 2021/9/2114:26
 */

public class DBCPTest {
    @Test
    //方式一
    public void testGetConnection() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();
        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true&&useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("123456");

        //还可以设置其他涉及数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection connection = source.getConnection();
        System.out.println(connection);


    }
    //方式二:使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties pros = new Properties();
        //方式一：
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Properties11/dbcp.properties");
        //方式二：
//        File file;
//        FileOutputStream is = new FileOutputStream(new File("src/Properties11/dbcp.properties"))
        pros.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
