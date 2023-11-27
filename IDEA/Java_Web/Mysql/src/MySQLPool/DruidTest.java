package MySQLPool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 金鱼
 * @title: DruidTest
 * @projectName Java_Web
 * @description: Druid数据库连接池技术
 * @date 2021/9/2115:30
 */
public class DruidTest {
@Test
    public void getConnection() throws Exception {
        Properties properties = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Properties11/druid.properties");
        properties.load(is);
        DataSource source = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = source.getConnection();
        System.out.println(connection);

    }
}
