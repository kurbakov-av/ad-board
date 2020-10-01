package com.example.adboard.service.moderate;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.ad.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ModeratorAdManagement implements ModeratorManagement<Ad> {

    private final AdRepository adRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void publish(Ad entity) {
        Assert.state(!entity.getAuthor().isBlocked(), "User blocked");
        Assert.state(entity.getStatus().isModeration(), "Ad not being moderated");

        entity.setStatus(Status.PUBLISHED);
        adRepository.save(entity);
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
