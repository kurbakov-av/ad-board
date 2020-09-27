package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdService {

    Ad getAd(Long id);

    Page<Ad> getPublishedAds(Pageable pageable);

    Page<Ad> getUserAds(Long userId, Pageable pageable);
}
