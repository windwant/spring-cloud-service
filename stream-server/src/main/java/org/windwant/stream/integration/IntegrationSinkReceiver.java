package org.windwant.stream.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.windwant.stream.core.IntegrationSink;

import java.time.LocalDateTime;

/**
 * 接收input exchange消息，
 * 回复消息到 output exchange
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = {IntegrationSink.class})
public class IntegrationSinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationSinkReceiver.class);

    @ServiceActivator(inputChannel = IntegrationSink.INPUT, outputChannel = IntegrationSink.OUTPUT)
    public Object receiver(LocalDateTime payLoad){
        logger.info("receive: {}", payLoad);
        return "send: " + LocalDateTime.now();
    }
}
