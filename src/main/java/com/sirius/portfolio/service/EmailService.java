package com.sirius.portfolio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(String name, String fromEmail, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(fromEmail);
        mailMessage.setTo("mubeenh452@gmail.com"); // Your receiving email
        mailMessage.setSubject("New Contact Message from " + name);
        mailMessage.setText("Name: " + name + "\n" + "Email: " + fromEmail + "\n" + "Message: " + message);

        mailSender.send(mailMessage);
    }
}
