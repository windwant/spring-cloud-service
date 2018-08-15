package org.windwant.amqp.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 18-8-15.
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitMQReceiver {
    @Autowired
    AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void receive(String msg){
        String rcv = "receive: " + msg;
        System.out.println(rcv);
    }
}
