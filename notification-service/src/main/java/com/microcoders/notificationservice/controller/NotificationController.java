package com.microcoders.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.microcoders.notificationservice.dto.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.context.annotation.Bean;
import com.microcoders.notificationservice.service.NotificationService;
import java.util.Properties;

@RestController
public class NotificationController {

    @Autowired
    public NotificationService notificationservice;

    @PostMapping("/send-mail")
    public String sendEmail(@RequestBody EmailDto emailDto){
        notificationservice.sendEmail(emailDto);
        return "mail sending initiated";
    }
    
}
