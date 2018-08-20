package org.windwant.stream.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.windwant.stream.core.ProcessorSink;

import java.time.LocalDateTime;

/**
 * 模拟应用
 * 监听 exchange s-input 消息
 * 回复 消息到 exchange s-output
 * Created by Administrator on 18-8-20.
 */
@EnableBinding(value = ProcessorSink.class)
public class AppProcessor {
    private static final Logger logger = LoggerFactory.getLogger(AppProcessor.class);

    @StreamListener(ProcessorSink.INPUT)
    @SendTo(ProcessorSink.OUTPUT)
    public Object receiveFromInput(Object payload){
        logger.info("received ping {}", payload);
        String pong = LocalDateTime.now() + " to ping - " + payload;
        logger.info("send pong {}", pong);
        return pong;
    }
}
