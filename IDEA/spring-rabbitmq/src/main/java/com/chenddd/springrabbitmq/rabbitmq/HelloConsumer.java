package com.chenddd.springrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* Author: chenddd
* Date: 2022/4/27 9:09
* FileName: HelloConsumer
* Description: 
*/
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("message:"+message);
    }
}
