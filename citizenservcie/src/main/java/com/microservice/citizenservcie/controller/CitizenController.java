package com.microservice.citizenservcie.controller;

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

import com.microservice.citizenservcie.entity.User;
import com.microservice.citizenservcie.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	private HttpServletRequest req;

	@GetMapping("/test")
	public ResponseEntity<String> test(){
		System.out.println(req.getServerPort());
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<User>> getById(@PathVariable Integer id){
		List<User> li = userRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(li, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User li = userRepo.save(user);
		return new ResponseEntity<>(li, HttpStatus.OK);
	}
}
