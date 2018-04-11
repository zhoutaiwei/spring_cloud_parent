package com.stream.hello.receiver;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 */
public interface SinkSender {
    @Output(Sink.INPUT)
    MessageChannel output();
}
