package chenddd.mq;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/25 0:33
* FileName: Consumer01
* Description: RabbitMQ消费者
*/
public class Consumer {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        //消费消息
        //参数1：消费哪个队列的消息 队列名称
        //参数2：开启消息的自动确认机制
        //参数3：消费时的回调接口
        channel.basicConsume("hello",true, new DefaultConsumer(channel){
            //最后一个参数：消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new StringBody =="+ new String(body));
            }
        });

//        RabbitMQUtils.closeConnection(connection, channel);
    }
}
