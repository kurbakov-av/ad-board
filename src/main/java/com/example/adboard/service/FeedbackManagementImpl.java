package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.feedback.Feedback;
import com.example.adboard.domain.feedback.FeedbackRepository;
import com.example.adboard.web.form.FeedbackForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedbackManagementImpl implements FeedbackManagement {

    private final FeedbackRepository feedbackRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Page<Feedback> getCurrentUserFeedback(Pageable pageable) {
        return feedbackRepository.findAllByAuthor(userService.getCurrentUser(), pageable);
    }

    @Override
    public void create(Ad ad, FeedbackForm form) {

    }

    @Override
    public void toModeration(Feedback feedback) {

    }
}
