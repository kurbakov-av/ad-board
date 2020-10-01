package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import com.example.adboard.domain.user.Password;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.AccountForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class AccountManagementImpl implements AccountManagement {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void updateAvatar(Image image) {
        User currentUser = userService.getCurrentUser();
        currentUser.setAvatar(image);
        userService.save(currentUser);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void changePassword(String oldPassword, String newPassword) {
        User currentUser = userService.getCurrentUser();
        Password password = currentUser.getPassword();
        Assert.state(passwordEncoder.matches(oldPassword, password.getValue()), "Password not matches");

        password = new Password();
        password.setValue(passwordEncoder.encode(newPassword));

        userService.save(currentUser);
    }

    @Override
    public void update(AccountForm form) {

    }
}
