package com.example.adboard.service.notificate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {

    @Override
    public void sendActivationEmailCode(String email, String code) {

    }

    @Override
    public void sendResetPasswordCode(String email, String code) {

    }

    @Override
    public void sendSuccessChangePassword(String email) {

    }
}
