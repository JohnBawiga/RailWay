package com.welltalk.caps.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Send an email.
     *
     * @param to      Recipient's email address.
     * @param subject Email subject.
     * @param text    Email content in HTML format.
     */
    public void sendEmail(String to, String subject, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true); // true for HTML content

            javaMailSender.send(mimeMessage);
            LOGGER.info("Email sent to {} with subject: '{}'", to, subject);
        } catch (MessagingException e) {
            // Error Handling: Handle exceptions, e.g., log or throw custom exceptions
            LOGGER.error("Failed to send email to {} with subject: '{}'", to, subject, e);
            // You may also throw a custom exception here or return a failure status
        }
    }
}
