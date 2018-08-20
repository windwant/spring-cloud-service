package org.windwant.stream.core;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorSink{
        String INPUT = "p-input";
        String OUTPUT = "p-output";

        @Input(ProcessorSink.INPUT)
        SubscribableChannel input();

        @Output(ProcessorSink.OUTPUT)
        MessageChannel output();
    }