package com.microcoders.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.microcoders.appointment.dto.AppointmentModel;
import com.microcoders.appointment.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/appointments")
	public String saveDetails(@RequestBody AppointmentModel request) {
		String patientId = appointmentService.saveDetails(request);
		return "appointment details saved successfully for PatientId: "+patientId;
	}
	
	@GetMapping("/patients/{patientId}")
	public AppointmentModel getDetails(@PathVariable String patientId) {
		return appointmentService.getDetails(patientId);
	}
	
	@GetMapping("/appointment/details")
	public List<AppointmentModel> getAppointmentDetails(){
		return appointmentService.getAppointments();
	}
}
