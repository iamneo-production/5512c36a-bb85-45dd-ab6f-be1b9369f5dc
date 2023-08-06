package com.microcoders.communicationservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcoders.communicationservice.service.CommunicationService;

@RestController
public class CommunicationController {
	
	@Autowired
	CommunicationService communicationService;

	@GetMapping("/communication/preferences")
	public ResponseEntity<Map<String, String>> getPatientPreference(@RequestParam("patientId") String patientId) {
		Map<String,String> response = communicationService.getPatientPreference(patientId);
		return ResponseEntity.ok().body(response);
	}
}
