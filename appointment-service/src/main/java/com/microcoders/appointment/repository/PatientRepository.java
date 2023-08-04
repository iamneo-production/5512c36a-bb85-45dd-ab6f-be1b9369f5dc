package com.microcoders.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcoders.appointment.model.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity,Long>{

	PatientEntity findByPatientId(String patientId);
}
