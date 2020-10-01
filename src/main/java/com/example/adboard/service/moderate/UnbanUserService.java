package com.example.adboard.service.moderate;

import com.example.adboard.domain.user.ban.UserBan;

public interface UnbanUserService {

    void unban(UserBan block, String reason);
}
