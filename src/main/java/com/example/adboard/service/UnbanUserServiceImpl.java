package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.domain.user.ban.UserBan;
import com.example.adboard.domain.user.ban.UserUnban;
import com.example.adboard.domain.user.ban.UserUnbanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UnbanUserServiceImpl implements UnbanUserService {

    private final UserUnbanRepository userUnbanRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void unban(UserBan bannedUser, String reason) {
        User targetUser = bannedUser.getTargetUser();
        Assert.state(targetUser.isBlocked(), "User not blocked");

        UserUnban userUnblock = new UserUnban();
        userUnblock.setAuthor(userService.getCurrentUser());
        userUnblock.setReason(reason);
        userUnblock.setTargetUser(targetUser);
        userUnblock.setUnblockingAt(LocalDateTime.now());

        userUnbanRepository.save(userUnblock);

        targetUser.setBlocked(false);
        userService.save(targetUser);
    }
}
