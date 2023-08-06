package com.microcoders.communicationservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcoders.communicationservice.model.PatientEntity;
import com.microcoders.communicationservice.repository.PatientRepository;

@Service
public class CommunicationService {

	@Autowired
	PatientRepository patientRepo;
	
	public Map<String, String> getPatientPreference(String patientId) {
		PatientEntity entity = patientRepo.findByPatientId(patientId);
		String preference=null;
		if(entity!=null)
			preference=entity.getPreference();
		Map<String,String> responseMap = new HashMap<>();
		responseMap.put(patientId, preference);
		return responseMap;
	}
}
