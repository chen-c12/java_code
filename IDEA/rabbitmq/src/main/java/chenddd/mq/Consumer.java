package chenddd.mq;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/25 0:33
* FileName: Consumer01
* Description: RabbitMQ������
*/
public class Consumer {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        //������Ϣ
        //����1�������ĸ����е���Ϣ ��������
        //����2��������Ϣ���Զ�ȷ�ϻ���
        //����3������ʱ�Ļص��ӿ�
        channel.basicConsume("hello",true, new DefaultConsumer(channel){
            //���һ����������Ϣ������ȡ������Ϣ
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new StringBody =="+ new String(body));
            }
        });

//        RabbitMQUtils.closeConnection(connection, channel);
    }
}
