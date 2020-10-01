package com.example.adboard.service.moderate;

import com.example.adboard.domain.complaint.Complaint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeratorComplaintManagement implements ModeratorManagement<Complaint> {

    @Override
    public void publish(Complaint entity) {

    }

    @Override
    public void reject(Complaint entity) {

    }

    @Override
    public void ban(Complaint entity) {

    }

    @Override
    public void unban(Complaint entity) {

    }
}
