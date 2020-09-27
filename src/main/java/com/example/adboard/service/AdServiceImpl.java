package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.ad.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;

    private final UserService userService;

    @Override
    public Ad getAd(Long id) {
        return null;
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
