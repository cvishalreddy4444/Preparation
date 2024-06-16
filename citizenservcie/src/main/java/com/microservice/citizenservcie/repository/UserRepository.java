package com.microservice.citizenservcie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.citizenservcie.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByVaccinationCenterId(Integer id);
	
}
