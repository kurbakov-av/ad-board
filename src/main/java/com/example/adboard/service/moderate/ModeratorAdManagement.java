package com.example.adboard.service.moderate;

import com.example.adboard.domain.ad.Ad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeratorAdManagement implements ModeratorManagement<Ad> {

    @Override
    public void publish(Ad entity) {

    }

    @Override
    public void reject(Ad entity) {

    }

    @Override
    public void ban(Ad entity) {

    }

    @Override
    public void unban(Ad entity) {

    }
}
