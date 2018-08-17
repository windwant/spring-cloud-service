package org.windwant.stream;

import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * Created by Administrator on 18-8-16.
 */
@EnableBinding(value = {Sink.class})
public class SinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receiver(byte[] payLoad){
        logger.info("receive: {}", new String(payLoad));
    }

    //注意返回值类型同listener的参数值相同
    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public byte[] transform(LocalDateTime msg){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(msg).getBytes();
    }
}
