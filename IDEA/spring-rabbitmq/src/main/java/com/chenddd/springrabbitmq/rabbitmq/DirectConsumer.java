package com.chenddd.springrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* Author: chenddd
* Date: 2022/4/27 14:46
* FileName: DirectConsumer
* Description: 
*/
@Component
public class DirectConsumer {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"info","error","warning"}
    ))
    public void receive(String message){
        System.out.println("direct message:"+message);
    }
}
