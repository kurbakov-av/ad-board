package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.RegisterForm;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface UserService {

    void register(RegisterForm form);

    void register(RegisterForm form, Set<GrantedAuthority> authorities);

    void requestResetPasswordCode(String identity);

    void changePassword(String resetCode, String newPassword);

    void remove(Long userId);

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?")
    @PreAuthorize("hasRole('ADMIN')")
    void removeNonActive();

    void softRemove(Long userId);

    void updateRoles(Long userId, Set<GrantedAuthority> authorities);

    User getCurrentUser();

    User getUser(Long id);

    void save(User user);
}
