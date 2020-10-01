package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import com.example.adboard.domain.user.ContactCard;
import com.example.adboard.domain.user.Password;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.AccountForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void update(AccountForm form) {
        User currentUser = userService.getCurrentUser();
        ContactCard contact = currentUser.getContactCard();

        ContactCard newContactCard = new ContactCard();
        newContactCard.setFirstName(getDefaultIfEmpty(form.getFirstName(), contact.getFirstName()));
        newContactCard.setLastName(getDefaultIfEmpty(form.getLastName(), contact.getLastName()));

        currentUser.setContactCard(newContactCard);

        userService.save(currentUser);
    }

    private String getDefaultIfEmpty(String value, String defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }

        return value;
    }
}
