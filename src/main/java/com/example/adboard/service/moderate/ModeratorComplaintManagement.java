package com.example.adboard.service.moderate;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.domain.complaint.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ModeratorComplaintManagement implements ModeratorManagement<Complaint> {

    private final ComplaintRepository complaintRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void publish(Complaint entity) {
        Assert.state(!entity.getAuthor().isBlocked(), "User blocked");
        Assert.state(entity.getStatus().isModeration(), "Complaint not being moderated");

        entity.setStatus(Status.PUBLISHED);
        complaintRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void reject(Complaint entity) {
        Assert.state(entity.getStatus().isModeration(), "Complaint not being moderated");

        entity.setStatus(Status.REJECT);
        complaintRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(Iterable<Complaint> list) {
        ModeratorManagement.super.ban(list);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void ban(Complaint entity) {
        Assert.state(!entity.getStatus().isBlock(), "Complaint already blocked");

        entity.setStatus(Status.BLOCK);
        complaintRepository.save(entity);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('MODERATOR')")
    public void unban(Complaint entity) {
        Assert.state(entity.getStatus().isBlock(), "Complaint not blocked");

        entity.setStatus(Status.MODERATION);
        complaintRepository.save(entity);
    }
}
