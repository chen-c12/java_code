package chenddd.direct;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 16:00
* FileName: Provider
* Description: routing direct
*/
public class Provider {

    private final static String EXCHANGE_NAME = "logs_direct";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //ͨ������������ ����1������������ ����2��direct  ·��ģʽ
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String routingKey = "error";

        channel.basicPublish(EXCHANGE_NAME, routingKey,null,("����direct�����Ļ���route key["+routingKey+"]").getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
