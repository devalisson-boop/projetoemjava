package com.example.pwa.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(String to, String subject, String body) {
        // Simula envio de e-mail (pode usar JavaMailSender de verdade)
        System.out.printf("Simulando envio de email para %s: [%s] %s%n", to, subject, body);
    }
}