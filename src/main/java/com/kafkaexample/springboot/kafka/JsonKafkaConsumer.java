package com.kafkaexample.springboot.kafka;

import com.kafkaexample.springboot.login.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	@KafkaListener(topics = "kafka_json" ,groupId="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message received -> %s", user.toString()));
	}
}
