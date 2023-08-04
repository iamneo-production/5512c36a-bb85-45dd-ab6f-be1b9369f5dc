package com.microcoders.appointment.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcoders.appointment.dto.AppointmentRequest;
import com.microcoders.appointment.model.AppointmentDetailsEntity;
import com.microcoders.appointment.model.PatientEntity;
import com.microcoders.appointment.repository.AppointmentRepository;
import com.microcoders.appointment.repository.PatientRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	public void saveDetails(AppointmentRequest request) {
		AppointmentDetailsEntity details = new AppointmentDetailsEntity();
		PatientEntity patient;
		if(request.isNewuser()) {
			patient = new PatientEntity();
			BeanUtils.copyProperties(request, patient);
			patientRepo.save(patient);
			details.setPatient(patient);
		}
		else
			patient = patientRepo.findByPatientId(request.getPatientId());
		BeanUtils.copyProperties(request, details);
		details.setPatient(patient);
		appointmentRepo.save(details);
	}
}
