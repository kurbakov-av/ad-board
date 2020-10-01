package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.feedback.Feedback;
import com.example.adboard.web.form.FeedbackForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackManagementImpl implements FeedbackManagement {

    @Override
    public Page<Feedback> getCurrentUserFeedback(Pageable pageable) {
        return null;
    }

    @Override
    public void create(Ad ad, FeedbackForm form) {

    }

    @Override
    public void toModeration(Feedback feedback) {

    }
}
