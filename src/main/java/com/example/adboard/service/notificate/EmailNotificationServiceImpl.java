package com.example.adboard.service.notificate;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {

    private final MailSender mailSender;

    @Override
    public void sendActivationEmailCode(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Activation email");
        message.setText(code);
        message.setSentDate(new Date());
        mailSender.send(message);
    }

    @Override
    public void sendResetPasswordCode(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset password code");
        message.setText(code);
        message.setSentDate(new Date());
        mailSender.send(message);
    }

    @Override
    public void sendSuccessChangePassword(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password change successful");
        message.setText("Password change successful");
        message.setSentDate(new Date());
        mailSender.send(message);
    }
}
