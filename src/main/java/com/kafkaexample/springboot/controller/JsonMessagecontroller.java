package com.kafkaexample.springboot.controller;

import com.kafkaexample.springboot.login.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaexample.springboot.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessagecontroller {

	private JsonKafkaProducer kafkaProducer;

	public JsonMessagecontroller(JsonKafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message sent to kafka topic");
	}
}
