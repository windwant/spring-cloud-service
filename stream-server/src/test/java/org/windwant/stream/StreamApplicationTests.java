package org.windwant.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private SinkSender sinkSender;

	@Test
	public void testStreamSend(){
		sinkSender.send(MessageBuilder.withPayload("test".getBytes()).build());
	}

	@Test
	public void testStreamIntegrationSend(){
	}
}
