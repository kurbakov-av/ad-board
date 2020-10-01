package com.example.adboard.service.moderate;

import com.example.adboard.domain.user.ban.UserBan;

public interface UnblockUserService {

    void unblock(UserBan block, String reason);
}
