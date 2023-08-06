package com.microcoders.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcoders.appointment.model.AppointmentDetailsEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentDetailsEntity,Long>{

}
