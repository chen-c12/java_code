package chenddd.workqueue;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/25 15:54
* FileName: Provider
* Description: 
*/
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("work", true, false, false, null);

        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "work", null, (i+"hello work queue").getBytes());
        }

        RabbitMQUtils.closeConnection(channel, connection);

    }
}
