package org.windwant.amqp.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 18-8-15.
 */
@Component
public class RabbitMQSender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "hello" + new Date();
        System.out.println("send: " + msg);
        this.amqpTemplate.convertAndSend("hello", msg);
    }
}
