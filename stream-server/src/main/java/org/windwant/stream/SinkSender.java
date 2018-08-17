package org.windwant.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 18-8-16.
 */
@Component
public class SinkSender {

    //注入信道，绑定默认input队列
    @Autowired
    @Output(Sink.INPUT)
    MessageChannel output;

    public void send(Message msg){
        output.send(msg);
    }

}
