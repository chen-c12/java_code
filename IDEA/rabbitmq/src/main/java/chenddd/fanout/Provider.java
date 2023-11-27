package chenddd.fanout;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 10:33
* FileName: Provider
* Description: �㲥
*/
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //��ͨ������ָ���Ľ����� ����1������������ ����2������������ fanout �㲥����
        channel.exchangeDeclare("logs", "fanout");

        //������Ϣ
        channel.basicPublish("logs", "", null, "fanout type message".getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
