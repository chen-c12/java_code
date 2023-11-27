package chenddd.topic;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 17:06
* FileName: Provider
* Description: Topic·¢²¼Õß
*/
public class Provider {

    private final static String EXCHANGE_NAME = "topic";
    private final static String ROUTING_KEY = "user.save";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, ("Topic to routing ["+ROUTING_KEY+"]").getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
