package com.chenddd.springrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* Author: chenddd
* Date: 2022/4/27 15:33
* FileName: TopicConsumer
* Description: 
*/
@Component
public class TopicConsumer {
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topic", type = "topic"),
            key = {"user.#", "user.save"}
    )
    })
    public void receive(String message){
        System.out.println("topic message:"+message);
    }
}
