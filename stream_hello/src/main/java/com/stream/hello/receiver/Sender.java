package com.stream.hello.receiver;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

//@EnableBinding(value = {Sender.SinkOutPut.class})
public class Sender {
    /**
     * 轮询生产消息，每隔2000ms发送一次消息
     * @return
     */
    //为了测其他东西，现注释掉，跟sinkreceiver用
    /*@Bean
    @InboundChannelAdapter(value = SinkOutPut.OUPUT,poller = @Poller(fixedDelay = "2000")) //对OUPUT通道的输出绑定
    public MessageSource<String>  timerMessageSource(){
        return () -> new GenericMessage<String>("this is Sender send the message");
    }*/
/*    interface SinkOutPut{
        String OUPUT= Sink.INPUT;

        @Output(SinkOutPut.OUPUT)
        MessageChannel output();
    }*/
}
