package com.microservice.vaccinationcenter.model;

import java.util.List;

import com.microservice.vaccinationcenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

	private VaccinationCenter center;
	
	private List<User> users;
	
}
