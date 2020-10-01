package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import com.example.adboard.web.form.AccountForm;

public interface AccountManagement {

    void updateAvatar(Image image);

    void changePassword(String oldPassword, String newPassword);

    void update(AccountForm form);
}
