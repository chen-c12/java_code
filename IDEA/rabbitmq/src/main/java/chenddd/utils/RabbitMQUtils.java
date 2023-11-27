package chenddd.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
* Author: chenddd
* Date: 2022/4/25 0:06
* FileName: RabbitMQUtils
* Description: RabbitMQ的工具类
*/
public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;
    static {
        connectionFactory = new ConnectionFactory();
        //设置连接rabbitmq主机
        connectionFactory.setHost("192.168.184.150");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Channel channel,Connection connection){

            try {
                if (channel!=null) {channel.close();}
                if(connection != null) {connection.close();}
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        System.out.println("RabbitMQUtils.getConnection() = " + RabbitMQUtils.getConnection());
    }*/
}
