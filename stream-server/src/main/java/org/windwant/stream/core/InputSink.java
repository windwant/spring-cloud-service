package org.windwant.stream.core;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputSink{
        String INPUT = "s-test";

        @Input(InputSink.INPUT)
        SubscribableChannel input();
    }