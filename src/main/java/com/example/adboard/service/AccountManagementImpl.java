package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.AccountForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountManagementImpl implements AccountManagement {

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void updateAvatar(Image image) {
        User currentUser = userService.getCurrentUser();
        currentUser.setAvatar(image);
        userService.save(currentUser);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public void update(AccountForm form) {

    }
}
