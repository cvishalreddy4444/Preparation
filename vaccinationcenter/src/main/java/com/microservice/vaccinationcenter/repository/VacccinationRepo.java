package com.microservice.vaccinationcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.vaccinationcenter.entity.VaccinationCenter;

public interface VacccinationRepo extends JpaRepository<VaccinationCenter, Integer> {

}
