package com.stream.hello.receiver;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import java.util.logging.Logger;

/**
 * 创建用于接收 rabbitMQ消息的消费者
 */
@EnableBinding({Sink.class})
public class SinkReceiver {

  //  @StreamListener(Sink.INPUT) 影响到MessageFeedbackle
    // @ServiceActivator(inputChannel = Sink.INPUT) //原生
    public void receive(Object playload) {
        System.out.println("receiver:"+playload);
    }

}
