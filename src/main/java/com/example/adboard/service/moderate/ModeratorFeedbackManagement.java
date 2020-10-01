package com.example.adboard.service.moderate;

import com.example.adboard.domain.feedback.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeratorFeedbackManagement implements ModeratorManagement<Feedback> {

    @Override
    public void publish(Feedback entity) {

    }

    @Override
    public void reject(Feedback entity) {

    }

    @Override
    public void ban(Feedback entity) {

    }

    @Override
    public void unban(Feedback entity) {

    }
}
