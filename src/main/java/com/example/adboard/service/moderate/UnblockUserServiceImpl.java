package com.example.adboard.service.moderate;

import com.example.adboard.domain.user.ban.UserBan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnblockUserServiceImpl implements UnblockUserService {

    @Override
    public void unblock(UserBan block, String reason) {

    }
}
