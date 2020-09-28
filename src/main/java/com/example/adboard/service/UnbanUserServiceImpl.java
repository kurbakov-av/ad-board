package com.example.adboard.service;

import com.example.adboard.domain.user.ban.UserBan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnbanUserServiceImpl implements UnbanUserService {

    @Override
    public void unban(UserBan bannedUser, String reason) {

    }
}
