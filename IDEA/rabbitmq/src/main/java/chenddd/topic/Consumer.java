package chenddd.topic;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 17:17
* FileName: Consumer
* Description: Topic Consumer
*/
public class Consumer {
    private final static String EXCHANGE_NAME = "topic";
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue, EXCHANGE_NAME, "user.*");


        channel.basicConsume(queue, true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Ïû·ÑÕß001£º"+new String(body));
            }
        });
    }
}
