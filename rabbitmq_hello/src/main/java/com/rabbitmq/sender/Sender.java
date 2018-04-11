package com.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Sender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send(){
        String content= "hello,"+new Date();
        System.out.println("sender:"+content);
        rabbitTemplate.convertAndSend("hello",content);
    }

}
