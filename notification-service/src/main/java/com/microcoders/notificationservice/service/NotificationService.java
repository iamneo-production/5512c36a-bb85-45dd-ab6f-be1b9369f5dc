package com.microcoders.notificationservice.service;

import com.microcoders.notificationservice.dto.EmailDto;
import com.microcoders.notificationservice.dto.SmsDto;

public interface NotificationService {
    public String sendEmail(EmailDto emailDto);
    public String sendSMS(SmsDto smsDto);
}
