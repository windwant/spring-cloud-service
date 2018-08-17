package org.windwant.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = {IntegrationSinkReceiver.InputSink.class})
public class IntegrationSinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationSinkReceiver.class);

    @ServiceActivator(inputChannel = InputSink.INPUT)
    public void receiver(byte[] payLoad){
        logger.info("receive: {}", new String(payLoad));
    }

    public interface InputSink{
        String INPUT = "i-test";
    }
}
