package com.techtalkathon.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtalkathon.kafka.producer.model.User;
import com.techtalkathon.kafka.producer.service.UserKafkaService;


@RestController
@RequestMapping("/user-service/kafka/producer")
public class UserController {

	@Autowired
	private UserKafkaService userKafkaService;
	
	 @PostMapping("/create")
	 public User createUser(@RequestBody User user) {
		 userKafkaService.sentKafkaTopic(user);
	 	return user;
	 }
	 
	 
	 
}
