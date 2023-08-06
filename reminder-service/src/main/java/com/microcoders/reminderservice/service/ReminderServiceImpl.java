package com.microcoders.reminderservice.service;

import com.microcoders.reminderservice.dto.AppointmentDetailsDto;
import com.microcoders.reminderservice.dto.EmailDto;
import com.microcoders.reminderservice.dto.SmsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService{

    @Autowired
    public RestTemplate restTemplate;
    private final String NOTI_SERVICE_URL = "http://localhost:8081";

    private List<AppointmentDetailsDto> appointmentDetails;

    @Override
    @Scheduled(fixedDelay = 60*1000) //86400000
    public List<AppointmentDetailsDto> getAppointmentDetails() {
        EmailDto emailDto = new EmailDto();
        emailDto.setReceiverId("jarshan701@gmail.com");
        emailDto.setSubject("Hello Bagula, Mail was written at "+ LocalDateTime.now());
        emailDto.setMessageText("Hi there, this mail is for testing purpose.");
        sendEmail(emailDto);
        return null;
    }

    @Override
    public void sendEmail(EmailDto emailDto) {
        String msg = restTemplate.postForObject(NOTI_SERVICE_URL+"/send-mail", emailDto, String.class);
        System.out.println(msg);
    }

    @Override
    public void sendSms(SmsDto smsDto) {

    }
}
