package com.microservice.vaccinationcenter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VaccinationCenter {

	@Id
	private Integer id;
	private String centerName;
	private String centerAddress;
	
}
