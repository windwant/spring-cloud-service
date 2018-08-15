package org.windwant.amqp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 18-8-15.
 */
@Component
public class KafkaSender {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(){
        String msg = "hello" + new Date();
        System.out.println("send: " + msg);
        this.kafkaTemplate.send("test1", msg.getBytes());
    }
}
