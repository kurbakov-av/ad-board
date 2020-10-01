package com.example.adboard.service.notificate;

public interface EmailNotificationService {

    void sendActivationEmailCode(String email, String code);

    void sendResetPasswordCode(String email, String code);

    void sendSuccessChangePassword(String email);
}
