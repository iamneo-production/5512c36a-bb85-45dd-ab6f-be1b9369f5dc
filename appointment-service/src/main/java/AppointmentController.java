package com.microcoders.appointment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

	@PostMapping("/store")
	public String saveDetails() {
		return "saved successfully";
	}
}
