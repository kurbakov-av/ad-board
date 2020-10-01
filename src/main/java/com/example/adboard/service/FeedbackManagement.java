package com.example.adboard.service;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.feedback.Feedback;
import com.example.adboard.web.form.FeedbackForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FeedbackManagement {

    Page<Feedback> getCurrentUserFeedback(Pageable pageable);

    void create(Ad ad, FeedbackForm form);

    void toModeration(Feedback feedback);
}
