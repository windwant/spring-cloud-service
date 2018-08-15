package org.windwant.amqp.kafka;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 18-8-15.
 */
@Component
@KafkaListener(topics = "test1", groupId = "cgroup")
public class KafkaReceiver {

    @KafkaHandler
    public void receive(byte[] msg) {
        String rcv = "receive: " + new String(msg);
        System.out.println(rcv);
    }
}
