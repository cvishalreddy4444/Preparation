package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.service.Producer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	Producer producer;
	
	@GetMapping("/send/{topic}/{message}")
	public String getMessageFromClient(@PathVariable String topic,@PathVariable String message) {
		producer.sendMessage(topic,message);
		
		return "success";
	}
	
}
