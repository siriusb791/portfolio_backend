package com.sirius.portfolio.controller;

import com.sirius.portfolio.model.ContactForm;
import com.sirius.portfolio.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")// Essential to allow your frontend to connect
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/api/contact")
    public ResponseEntity<String> handleContactForm(@RequestBody ContactForm formData) {
        emailService.sendContactEmail(
                formData.getName(),
                formData.getEmail(),
                formData.getMessage()
        );

        return ResponseEntity.ok("Thank you for your message!");
    }
}