package com.example.adboard.service;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.ad.AdRepository;
import com.example.adboard.domain.ad.CategoryRepository;
import com.example.adboard.domain.image.Image;
import com.example.adboard.util.AdMapper;
import com.example.adboard.web.form.AdForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AdManagementImpl implements AdManagement {

    private final UserService userService;

    private final AdRepository adRepository;

    private final ImageStorage imageStorage;

    private final CategoryRepository categoryRepository;

    private final AdMapper mapper;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Page<Ad> getCurrentUserAds(Pageable pageable) {
        return adRepository.findAllByAuthor(userService.getCurrentUser(), pageable);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and #principal.username.equalsIgnoreCase(#ad.author.username)")
    public void disable(Ad ad) {
        Assert.state(ad.getStatus().isPublished(), "Ad not published");
        ad.setStatus(Status.CLOSE);
        adRepository.save(ad);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and #principal.username.equalsIgnoreCase(#ad.author.username)")
    public void update(Ad ad, AdForm form) {
        if (!ad.getTitle().equals(form.getTitle())) {
            ad.setTitle(form.getTitle());
        }

        if (!ad.getDescription().equals(form.getTitle())) {
            ad.setDescription(form.getDescription());
        }

        if (!ad.getCategory().getId().equals(form.getCategoryId())) {
            ad.setCategory(categoryRepository.getOne(form.getCategoryId()));
        }

        if (!ad.getAddress().equals(form.getAddress())) {
            ad.setAddress(form.getAddress());
        }

        if (!ad.getPrice().equals(form.getPrice())) {
            ad.setPrice(form.getPrice());
        }

        adRepository.save(ad);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public void create(AdForm form, Collection<MultipartFile> files) {
        Collection<Image> images = imageStorage.store(files);

        Ad ad = mapper.toAd(form);
        ad.setImages(images);
        ad.setAuthor(userService.getCurrentUser());
        ad.setCategory(categoryRepository.getOne(form.getCategoryId()));

        adRepository.save(ad);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and #principal.username.equalsIgnoreCase(#ad.author.username)")
    public void toModeration(Ad ad) {
        Assert.state(ad.getStatus().isCreated(), "Ad not new");
        ad.setStatus(Status.MODERATION);
        adRepository.save(ad);
    }
}
