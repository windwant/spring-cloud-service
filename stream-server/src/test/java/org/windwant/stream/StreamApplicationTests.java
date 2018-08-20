package org.windwant.stream;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

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
		JSONObject msg = new JSONObject();
		msg.put("name", "lilei");
		msg.put("age", 10);
		sinkSender.send(MessageBuilder.withPayload(msg.toJSONString()).build());
		sinkSender.send(MessageBuilder.withPayload(LocalDateTime.now()).build());
		SecurityProperties.User user = new SecurityProperties.User();
		user.setName("lisa");
		user.setPassword("123456");
		sinkSender.send(MessageBuilder.withPayload(user).build());
	}

	@Test
	public void testStreamIntegrationSend(){
	}
}
