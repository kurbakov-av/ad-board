package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.ad.AdRepository;
import com.example.adboard.web.form.AdForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AdManagementImpl implements AdManagement {

    private final UserService userService;

    private final AdRepository adRepository;

    @Override
    public Page<Ad> getCurrentUserAds(Pageable pageable) {
        return null;
    }

    @Override
    public void disable(Ad ad) {

    }

    @Override
    public void update(Ad ad, AdForm form) {

    }

    @Override
    public void create(AdForm form, Collection<MultipartFile> files) {

    }

    @Override
    public void toModeration(Ad ad) {

    }
}
