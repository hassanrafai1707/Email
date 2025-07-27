package com.example.Emailtest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerifyEmail(String toEmail,String name ,String token){
        try {
            SimpleMailMessage message =new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Verify Account");
            message.setText(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
