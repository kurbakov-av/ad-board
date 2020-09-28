package com.example.adboard.service;

import com.example.adboard.domain.user.ban.UserBan;

public interface UnbanUserService {
    void unban(UserBan bannedUser, String reason);
}
