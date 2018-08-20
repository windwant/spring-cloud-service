package org.windwant.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.Transformer;
import org.windwant.stream.core.InputSink;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = {InputSink.class, SinkSender.class})
public class SinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(InputSink.INPUT)
    public void receiver(byte[] payLoad){
        logger.info("receive: {}", new String(payLoad));
    }

    //注意返回值类型同listener的参数值相同
    @Transformer(inputChannel = InputSink.INPUT, outputChannel = InputSink.INPUT)
    public byte[] transform(LocalDateTime msg){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(msg).getBytes();
    }
}
