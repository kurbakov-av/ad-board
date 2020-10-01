package com.example.adboard.service.moderate;

import com.example.adboard.domain.user.User;
import com.example.adboard.domain.user.ban.UserBan;
import com.example.adboard.domain.user.ban.UserBanRepository;
import com.example.adboard.service.UserService;
import com.example.adboard.web.form.UserBanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class BanUserServiceImpl implements BanUserService {

    private final UserBanRepository userBanRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(User user, UserBanForm form) {
        Assert.state(!user.isBlocked(), "User already blocked");

        UserBan userBlock = new UserBan();
        userBlock.setAuthor(userService.getCurrentUser());
        userBlock.setReason(form.getReason());
        userBlock.setStartAt(form.getStartAt());
        userBlock.setTargetUser(user);
        userBlock.setEndAt(form.getEndAt());

        if (Boolean.TRUE.equals(form.getPermanent())) {
            userBlock.setPermanent(true);
        }

        userBanRepository.save(userBlock);

        user.setBlocked(true);
        userService.save(user);
    }
}
