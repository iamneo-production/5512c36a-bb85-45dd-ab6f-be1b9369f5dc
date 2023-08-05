package com.microcoders.notificationservice.service;

import com.microcoders.notificationservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final JavaMailSender javaMailSender;
    private final ExecutorService executorService;

    @Autowired
    public NotificationServiceImpl(JavaMailSender javaMailSender){
        this.executorService = Executors.newFixedThreadPool(2);
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail(EmailDto emailDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getReceiverId());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessageText());
        executorService.submit(()->{
            try{
                javaMailSender.send(message);
            }catch (Exception e){
                System.out.println("Error");
            }
        });
        return "mail send initiated";
    }

    public String sendSMS(SmsDto smsDto){
        return "sms send initiated";
    }
}
