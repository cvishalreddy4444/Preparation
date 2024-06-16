package com.microservice.vaccinationcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.vaccinationcenter.entity.VaccinationCenter;
import com.microservice.vaccinationcenter.model.RequiredResponse;
import com.microservice.vaccinationcenter.model.User;
import com.microservice.vaccinationcenter.repository.VacccinationRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {
	
	@Autowired
	VacccinationRepo vcRepo;
	
	@Autowired
	RestTemplate rest;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addUser(@RequestBody VaccinationCenter center){
		VaccinationCenter li = vcRepo.save(center);
		return new ResponseEntity<>(li, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenServiceDownTime")
	public ResponseEntity<RequiredResponse> allDataBasedOnCenterId(@PathVariable Integer id){
		RequiredResponse res = new RequiredResponse();
		VaccinationCenter cen = vcRepo.findById(id).get();
		res.setCenter(cen);
		
		//get all registered user to vaccinatoin center response
		List<User> citi = rest.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		res.setUsers(citi);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<RequiredResponse> handleCitizenServiceDownTime(@PathVariable Integer id){
		RequiredResponse res = new RequiredResponse();
		VaccinationCenter cen = vcRepo.findById(id).get();
		res.setCenter(cen);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
}
