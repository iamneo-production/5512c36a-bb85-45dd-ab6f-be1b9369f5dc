package com.microcoders.communicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcoders.communicationservice.model.PatientEntity;


public interface PatientRepository extends JpaRepository<PatientEntity,Long>{

	PatientEntity findByPatientId(String patientId);
}
