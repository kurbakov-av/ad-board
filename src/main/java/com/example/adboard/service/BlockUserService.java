package com.example.adboard.service;

import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.UserBanForm;

public interface BlockUserService {
    void ban(User user, UserBanForm form);
}
