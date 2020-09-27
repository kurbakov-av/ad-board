package com.example.adboard.service;

import com.example.adboard.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.adboard.web.form.RegisterForm;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

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
    @Transactional
    @PreAuthorize("isAnonymous()")
    public void requestResetPasswordCode(String identity) {
        User user = userRepository.findByUsernameOrEmail(identity, identity)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + identity));

        Password.Reset reset = new Password.Reset();
        reset.setResetCode(UUID.randomUUID().toString());
        reset.setExpiredAt(LocalDateTime.now().plusMinutes(15));

        Password password = user.getPassword();
        password.setReset(reset);

        userRepository.save(user);
    }

    @Override
    @Transactional
    @PreAuthorize("isAnonymous()")
    public void changePassword(String resetCode, String newPassword) {
        User user = userRepository.findByPassword_Reset_ResetCode(resetCode)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by reset code -> " + resetCode));

        Password password = new Password();
        password.setValue(passwordEncoder.encode(newPassword));
        user.setPassword(password);

        userRepository.save(user);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void remove(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 * * ?")
    @PreAuthorize("hasRole('ADMIN')")
    public void removeNonActive() {
        userRepository.findAllByActivation_ActiveFalse().forEach(userRepository::delete);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void softRemove(Long userId) {
        User user = userRepository.getOne(userId);
        user.setMarkRemoved(true);
        userRepository.save(user);
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
