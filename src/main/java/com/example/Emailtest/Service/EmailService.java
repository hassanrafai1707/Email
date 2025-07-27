package com.example.Emailtest.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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
           log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
