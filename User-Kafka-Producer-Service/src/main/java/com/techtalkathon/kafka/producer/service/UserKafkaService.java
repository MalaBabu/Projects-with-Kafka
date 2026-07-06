package com.techtalkathon.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.techtalkathon.kafka.producer.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserKafkaService {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	public void sentKafkaTopic(User user) {
		kafkaTemplate.send("user-topic", "user", user);
		log.info("sentKafkaTopic - sent Kafka Topic");

	}
	
	
}
