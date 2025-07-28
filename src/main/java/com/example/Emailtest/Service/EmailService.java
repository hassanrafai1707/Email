package com.example.Emailtest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerifyEmail(String toEmail,String name ,String token){ 
        try {
             String verificationLink = "http://localhost:8080/api/student/confirm?token=" + token;
            SimpleMailMessage message =new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Verify Account");
            message.setText("Hello"+name+",\n\nPlease verify your email"+verificationLink);
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("Failed to send verification email to {}: {}", toEmail, e.getMessage(), e);
           log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
