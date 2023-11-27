package com.chenddd.springrabbitmq.testmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* Author: chenddd
* Date: 2022/4/27 9:02
* FileName: TestRabbitMQ
* Description: 测试RabbitMQ
*/
@SpringBootTest
public class TestRabbitMQ {

    @Autowired
    RabbitTemplate rabbitTemplate;

    //hello world 模型
    @Test
    public void test01(){
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    //work 模型
    @Test
    public void test02(){
        rabbitTemplate.convertAndSend("work", "work 发送的消息");
    }

    //fanout模型
    @Test
    public void test03(){
        rabbitTemplate.convertAndSend("logs", "", "fanout模型发送的消息");
    }

    //routing模型
    @Test
    public void test04(){
        rabbitTemplate.convertAndSend("directs" , "info", "发送info的路由信息");
    }

    //topics模型
    @Test
    public void test05(){
        rabbitTemplate.convertAndSend("topic", "user.save", "topic 发送的消息");
    }
}

