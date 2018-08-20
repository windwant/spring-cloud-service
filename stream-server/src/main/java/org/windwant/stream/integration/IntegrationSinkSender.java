package org.windwant.stream.integration;

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
import org.windwant.stream.core.IntegrationSink;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 生成发送消息到input exchange，
 * 监听output exchange 消息
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = IntegrationSink.class)
public class IntegrationSinkSender {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationSinkSender.class);

    @Bean
    @InboundChannelAdapter(channel = IntegrationSink.INPUT, poller = @Poller(fixedRate = "2000"))
    public MessageSource timerMessageSource() {
        return new MessageSource<Date>() {
            @Override
            public Message receive() {
                Message msg = MessageBuilder.withPayload(LocalDateTime.now()).build();
                logger.info("send {}", msg.getPayload());
                return msg;
            }
        };
    }

    @StreamListener(IntegrationSink.OUTPUT)
    public void receiveFromInput(Object payload) {
        logger.info("received {}", new String((byte[]) payload));
    }
}
