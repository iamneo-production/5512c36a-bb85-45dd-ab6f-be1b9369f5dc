package com.microcoders.appointment.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcoders.appointment.dto.AppointmentModel;
import com.microcoders.appointment.model.AppointmentDetailsEntity;
import com.microcoders.appointment.model.PatientEntity;
import com.microcoders.appointment.repository.AppointmentRepository;
import com.microcoders.appointment.repository.PatientRepository;
import com.microcoders.appointment.util.AppointmentUtil;
@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	private static final SecureRandom DEFAULT_NUMBER_GENERATOR = new SecureRandom();

    private static final char[] CUSTOM_ALPHABET =
            "0123456789ABCDEFGH".toCharArray();
	
	public String saveDetails(AppointmentModel request) {
		AppointmentDetailsEntity details = new AppointmentDetailsEntity();
		PatientEntity patient;
		if(request.isNewuser()) {
			patient = new PatientEntity();
			BeanUtils.copyProperties(request, patient);
			patient.setPatientId(generatePatientId());
			patientRepo.save(patient);
			details.setPatient(patient);
		}
		else
			patient = patientRepo.findByPatientId(request.getPatientId());
		BeanUtils.copyProperties(request, details);
		details.setPatient(patient);
		appointmentRepo.save(details);
		return patient.getPatientId();
	}
	
	public AppointmentModel getDetails(String patientId) {
		PatientEntity patient = patientRepo.findByPatientId(patientId);
		AppointmentModel response = new AppointmentModel();
		BeanUtils.copyProperties(patient, response);
		return response;
	}
	
	public String generatePatientId() {
		return AppointmentUtil.randomNanoId(DEFAULT_NUMBER_GENERATOR, CUSTOM_ALPHABET, 6);
	}

	public List<AppointmentModel> getAppointments(){
		List<AppointmentDetailsEntity> appointments = appointmentRepo.findAll();
		List<AppointmentModel> modelDetails = new ArrayList<>();
		AppointmentModel model;
		for(AppointmentDetailsEntity entity:appointments){
			model = new AppointmentModel();
			BeanUtils.copyProperties(entity,model);
			model.setPatientId(entity.getPatient().getPatientId());
			modelDetails.add(model);
		}
		return modelDetails;
	}
}
