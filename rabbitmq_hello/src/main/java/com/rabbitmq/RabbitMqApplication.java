package com.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class RabbitMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class,args);
    }

    /**
     * 建一个队列，name为hello
     * @return
     */
    @Bean
    public Queue getQueue(){
        Queue hello = new Queue("hello");
        return hello;
    }

}
