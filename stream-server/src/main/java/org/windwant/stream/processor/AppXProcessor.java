package org.windwant.stream.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.windwant.stream.core.ProcessorSink;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 模拟应用X
 * 监听 exchange s-output 消息
 * 生成并发送消息到 exchange s-input
 * Created by Administrator on 18-8-20.
 */
@EnableBinding(value = ProcessorSink.class)
public class AppXProcessor {
    private static final Logger logger = LoggerFactory.getLogger(AppXProcessor.class);

    @Bean
    @InboundChannelAdapter(channel = ProcessorSink.INPUT, poller = @Poller(fixedRate = "2000"))
    public MessageSource appMessageSource(){
        return new MessageSource<Date>() {
            @Override
            public Message receive() {
                Message msg = MessageBuilder.withPayload(LocalDateTime.now()).build();
                logger.info("send ping - {}", msg.getPayload());
                return msg;
            }
        };
    }

    @StreamListener(ProcessorSink.OUTPUT)
    public void receiveFromInput(Object payload){
        logger.info("received pong - {}", new String((byte[]) payload));
    }
}
