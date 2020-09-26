package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.adboard.web.form.RegisterForm;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterForm form) {

    }

    @Override
    public void register(RegisterForm form, Set<GrantedAuthority> authorities) {

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
