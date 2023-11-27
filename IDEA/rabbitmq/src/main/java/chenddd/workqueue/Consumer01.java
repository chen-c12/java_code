package chenddd.workqueue;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/25 16:02
* FileName: Consumer01
* Description: workqueue
*/
public class Consumer01 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("������111 ==��"+new String(body));
                //�ֶ�ȷ�� ����1���ֶ�ȷ�ϱ�ʶ ����2��false ÿ��ȷ��һ��
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
