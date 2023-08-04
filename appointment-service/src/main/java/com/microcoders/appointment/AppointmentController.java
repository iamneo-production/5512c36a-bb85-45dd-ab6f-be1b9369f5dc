package com.microcoders.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microcoders.appointment.dto.AppointmentRequest;
import com.microcoders.appointment.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/store")
	public String saveDetails(@RequestBody AppointmentRequest request) {
		appointmentService.saveDetails(request);
		return "saved successfully";
	}
}
