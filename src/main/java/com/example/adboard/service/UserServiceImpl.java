package com.example.adboard.service;

import com.example.adboard.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.adboard.web.form.RegisterForm;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PreAuthorize("isAnonymous()")
    public void register(RegisterForm form) {
        register(form, Set.of(Role.USER));
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void register(RegisterForm form, Set<GrantedAuthority> authorities) {
        Password password = new Password();
        password.setValue(passwordEncoder.encode(form.getPassword()));

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(password);
        user.setEmail(form.getEmail());
        user.setAuthorities(Set.of(Role.USER));
        user.setContactCard(new ContactCard(form.getUsername(), null, null));

        userRepository.save(user);
    }

    @Override
    public void requestResetPasswordCode(String identity) {

    }

    @Override
    public void changePassword(String resetCode, String newPassword) {

    }

    @Override
    public void remove(Long userId) {

    }

    @Override
    public void removeNonActive() {

    }

    @Override
    public void softRemove(Long userId) {

    }

    @Override
    public void updateRoles(Long userId, Set<GrantedAuthority> authorities) {

    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
