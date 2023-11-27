package com.chenddd.springrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
* Author: chenddd
* Date: 2022/4/27 10:48
* FileName: FanoutConsumer
* Description: Fanout的消费者
*/
@Component
public class FanoutConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")   //绑定交换机
            )
    })
    public void receive(String message){
        System.out.println("message:"+message);
    }

}
