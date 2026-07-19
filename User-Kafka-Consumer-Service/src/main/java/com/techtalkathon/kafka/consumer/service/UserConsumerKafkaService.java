package com.techtalkathon.kafka.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
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
	public User getUserMessage2(ConsumerRecord<String, User> record) {
		this.user=record.value();
		log.info("user-topic2 --> Received User Topic with userId={} ----> {}",user.getUserId(), user);
		
		log.info("""
	            Topic      : {}
	            Partition  : {}
	            Offset     : {}
	            Key        : {}
	            User       : {}
	            """,
	            record.topic(),
	            record.partition(),
	            record.offset(),
	            record.key(),
	            user);
		
		
		return user;
	}
	
	public User getUser() {
		return this.user;
	}

}
