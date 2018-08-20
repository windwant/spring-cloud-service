package org.windwant.stream.core;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface IntegrationSink {
    String INPUT = "i-input";

    String OUTPUT = "i-output";

    @Output(IntegrationSink.OUTPUT)
    MessageChannel output();
}