package org.windwant.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

/**
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = IntegrationSinkSender.OutPutSink.class)
public class IntegrationSinkSender {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationSinkSender.class);

    @Bean
    @InboundChannelAdapter(channel = OutPutSink.OUTPUT, poller = @Poller(fixedRate = "2000"))
    public MessageSource timerMessageSource(){
        return new MessageSource<Date>() {
            @Override
            public Message receive() {
                Message msg = MessageBuilder.withPayload(new Date()).build();
                logger.info("send {}", msg.toString());
                return msg;
            }
        };
    }

    public interface OutPutSink{
        String OUTPUT = "test";

        @Output(OutPutSink.OUTPUT)
        MessageChannel output();
    }
}
