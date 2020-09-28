package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.web.form.AdForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface AdManagement {
    Page<Ad> getCurrentUserAds(Pageable pageable);

    void disable(Ad ad);

    void update(Ad ad, AdForm form);

    void create(AdForm form, Collection<MultipartFile> files);

    void toModeration(Ad ad);
}
