package com.chenddd.springrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* Author: chenddd
* Date: 2022/4/27 14:35
* FileName: WorkConsumer
* Description: 
*/
@Component
@RabbitListener(queuesToDeclare = @Queue("work"))
public class WorkConsumer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("work message:"+ message);
    }
}
