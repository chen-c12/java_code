package chenddd.mq;

import chenddd.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
* Author: chenddd
* Date: 2022/4/24 23:28
* FileName: Provider
* Description: 
*/
public class Provider {
    /**
     * ������Ϣ
     */
    @Test
    public void testSendMessage() throws IOException, TimeoutException {

        //��ȡ���Ӷ���
        Connection connection = RabbitMQUtils.getConnection();

        //��ȡ������ͨ��
        Channel channel = connection.createChannel();

        //ͨ���󶨶�Ӧ����Ϣ����
        //����1:  �������� ������в������Զ�����
        //����2:  ����������������Ƿ�Ҫ�־û� true �־û�����   false ���־û�
        //����3:  exclusive �Ƿ��ռ����  true ��ռ����   false  ����ռ
        //����4:  autoDelete: �Ƿ���������ɺ��Զ�ɾ������  true �Զ�ɾ��  false ���Զ�ɾ��
        //����5:  ���⸽�Ӳ���
        channel.queueDeclare("hello", false, false, false, null);

        //������Ϣ
        //����1������������ ����2���������� ����3��������Ϣ�������� ����4����Ϣ�ľ�������
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbitMQ".getBytes());

       RabbitMQUtils.closeConnection(channel,connection);

    }

}
