package com.techtalkathon.kafka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtalkathon.kafka.consumer.service.UserConsumerKafkaService;
import com.techtalkathon.kafka.producer.model.User;

@RestController
@RequestMapping("/user-service/kafka/consumer")
public class UserConsumerKafkaController {

	
	@Autowired
	private UserConsumerKafkaService userConsumerKafkaService;
	
	 @GetMapping("/getUser")
	 public User createUser() {
		 return userConsumerKafkaService.getUser();
	 }
	
}
