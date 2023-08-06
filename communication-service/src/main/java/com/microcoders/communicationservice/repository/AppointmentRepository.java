package com.microcoders.communicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcoders.communicationservice.model.AppointmentDetailsEntity;


public interface AppointmentRepository extends JpaRepository<AppointmentDetailsEntity,Long>{

}
