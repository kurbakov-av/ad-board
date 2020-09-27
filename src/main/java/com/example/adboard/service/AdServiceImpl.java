package com.example.adboard.service;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.ad.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("isAnonymous() or isAuthenticated()")
    public Ad getAd(Long id) {
        return adRepository.findByIdAndStatus(id, Status.PUBLISHED)
                .orElseThrow(() -> new EntityNotFoundException("Ad not found!"));
    }

    @Override
    public Page<Ad> getPublishedAds(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Ad> getUserAds(Long userId, Pageable pageable) {
        return null;
    }
}
