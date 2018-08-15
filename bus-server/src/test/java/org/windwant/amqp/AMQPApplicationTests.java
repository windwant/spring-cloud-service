package org.windwant.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.windwant.amqp.kafka.KafkaSender;
import org.windwant.amqp.rabbitmq.RabbitMQSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AMQPApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	RabbitMQSender rabbitMQSender;

	@Autowired
	KafkaSender kafkaSender;

	@Test
	public void testRabbitmq(){
		rabbitMQSender.send();
	}

	@Test
	public void testKafka(){
		kafkaSender.send();
	}
}
