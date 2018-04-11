package com.stream.hello.receiver;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;




/*

@EnableBinding(value = {Processor.class})
public class MessageFeedback {

    @StreamListener(Processor.INPUT) //接受来自input的消息
    @SendTo(Processor.OUTPUT) //将消息发送给outpue
    public Object receiverFromSend(Object obj) {
        System.out.println("receiver form input:" + obj);
        return "retrun -" + obj;
    }
}
*/






