package chenddd.direct;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 16:24
* FileName: Consumer002
* Description: 
*/
public class Consumer002 {
    private final static String EXCHANGE_NAME = "logs_direct";
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue, EXCHANGE_NAME, "info");
        channel.queueBind(queue, EXCHANGE_NAME, "warning");
        channel.queueBind(queue, EXCHANGE_NAME, "error");

        channel.basicConsume(queue, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Ïû·ÑÕß002£º"+new String(body));
            }
        });
    }
}
