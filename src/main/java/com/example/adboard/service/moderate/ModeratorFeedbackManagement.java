package com.example.adboard.service.moderate;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.feedback.Feedback;
import com.example.adboard.domain.feedback.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ModeratorFeedbackManagement implements ModeratorManagement<Feedback> {

    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void publish(Feedback entity) {
        Assert.state(!entity.getAuthor().isBlocked(), "User blocked");
        Assert.state(entity.getStatus().isModeration(), "Feedback not being moderated");

        entity.setStatus(Status.PUBLISHED);
        feedbackRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void reject(Feedback entity) {
        Assert.state(entity.getStatus().isModeration(), "Feedback not being moderated");

        entity.setStatus(Status.REJECT);
        feedbackRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(Iterable<Feedback> list) {
        ModeratorManagement.super.ban(list);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(Feedback entity) {
        Assert.state(!entity.getStatus().isBlock(), "Feedback already blocked");

        entity.setStatus(Status.BLOCK);
        feedbackRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void unban(Feedback entity) {
        Assert.state(entity.getStatus().isBlock(), "Feedback not blocked");

        entity.setStatus(Status.MODERATION);
        feedbackRepository.save(entity);
    }
}
