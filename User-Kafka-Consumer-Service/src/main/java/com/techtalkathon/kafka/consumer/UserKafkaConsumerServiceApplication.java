package com.techtalkathon.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.techtalkathon.kafka"})
public class UserKafkaConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserKafkaConsumerServiceApplication.class, args);
	}

}
