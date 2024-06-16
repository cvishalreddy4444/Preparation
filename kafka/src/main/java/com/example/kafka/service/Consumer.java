package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	
	@KafkaListener(topics="test_out",groupId="grouptest")
	public void listenTopic(String message) {
		System.out.println("the message recieved is "+message);
	}
	
	@KafkaListener(topics="t1",groupId="grouptest")
	public void listenTopict(String message) {
		System.out.println("the message recieved from t1 is "+message);
	}
	
	@KafkaListener(topics="t2",groupId="grouptest1")
	public void listenTopictt(String message) {
		System.out.println("the message recieved from t2 is "+message);
	}
	
}
