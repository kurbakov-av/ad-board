package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import com.example.adboard.web.form.AccountForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountManagementImpl implements AccountManagement {

    @Override
    public void updateAvatar(Image image) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public void update(AccountForm form) {

    }
}
