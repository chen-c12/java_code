package chenddd.fanout;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/26 10:43
* FileName: Consumer001
* Description: 
*/
public class Consumer001 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs", "fanout");
        //临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queue, "logs", "");
        //消费消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
            }
        });
    }
}
