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

        //ͨ���󶨽�����
        channel.exchangeDeclare("logs", "fanout");
        //��ʱ����
        String queue = channel.queueDeclare().getQueue();
        //�󶨽������Ͷ���
        channel.queueBind(queue, "logs", "");
        //������Ϣ
        channel.basicConsume(queue, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("������1��"+new String(body));
            }
        });
    }
}
