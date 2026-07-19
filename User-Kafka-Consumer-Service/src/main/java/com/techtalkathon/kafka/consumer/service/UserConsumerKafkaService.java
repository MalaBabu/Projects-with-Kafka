package com.techtalkathon.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.techtalkathon.kafka.producer.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserConsumerKafkaService {

	private User user=null;
	
	@KafkaListener(topics = "user-topic", groupId = "user-consumer")
	public User getUserMessage(User user) {
		this.user=user;
		log.info("user-topic --> Received User Topic with userId={} ----> {}",user.getUserId(), user);
		return user;
	}
	
	@KafkaListener(topics = "user-topic2", groupId = "user-consumer")
	public User getUserMessage2(User user) {
		this.user=user;
		log.info("user-topic2 --> Received User Topic with userId={} ----> {}",user.getUserId(), user);
		return user;
	}
	
	public User getUser() {
		return this.user;
	}

}
