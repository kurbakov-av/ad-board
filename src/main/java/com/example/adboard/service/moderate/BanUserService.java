package com.example.adboard.service.moderate;

import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.UserBanForm;

public interface BanUserService {

    void ban(User user, UserBanForm form);
}
