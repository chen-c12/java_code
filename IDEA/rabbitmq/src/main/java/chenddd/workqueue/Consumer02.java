package chenddd.workqueue;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/25 16:12
* FileName: Consumer02
* Description: 
*/
public class Consumer02 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();
        //ÿһ������һ����Ϣ
        channel.basicQos(1);
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("������222 ==��"+new String(body));
                //�ֶ�ȷ�� ����1���ֶ�ȷ�ϱ�ʶ ����2��false ÿ��ȷ��һ��
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
