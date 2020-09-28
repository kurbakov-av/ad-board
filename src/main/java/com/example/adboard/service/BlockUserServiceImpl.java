package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.domain.user.ban.UserBan;
import com.example.adboard.domain.user.ban.UserBanRepository;
import com.example.adboard.web.form.UserBanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class BlockUserServiceImpl implements BlockUserService {

    private final UserBanRepository userBanRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(User user, UserBanForm form) {
        Assert.state(!user.isBlocked(), "User already blocked");

        UserBan bannedUser = new UserBan();
        bannedUser.setAuthor(userService.getCurrentUser());
        bannedUser.setReason(form.getReason());
        bannedUser.setStartAt(form.getStartAt());
        bannedUser.setTargetUser(user);
        bannedUser.setEndAt(form.getEndAt());

        if (form.getPermanent() != null && form.getPermanent()) {
            bannedUser.setPermanent(true);
        }

        userBanRepository.save(bannedUser);

        user.setBlocked(true);
        userService.save(user);
    }
}
