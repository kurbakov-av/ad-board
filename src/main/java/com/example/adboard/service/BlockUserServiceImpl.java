package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.UserBanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockUserServiceImpl implements BlockUserService {

    @Override
    public void ban(User user, UserBanForm form) {

    }
}
