package com.microcoders.reminderservice.service;

import com.microcoders.reminderservice.dto.AppointmentDetailsDto;
import com.microcoders.reminderservice.dto.EmailDto;
import com.microcoders.reminderservice.dto.SmsDto;

import java.util.List;

public interface ReminderService {
    List<AppointmentDetailsDto> getAppointmentDetails();
    void sendEmail(EmailDto emailDto);
    void sendSms(SmsDto smsDto);
}
