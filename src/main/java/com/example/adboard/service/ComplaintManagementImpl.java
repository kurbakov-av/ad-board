package com.example.adboard.service;

import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.domain.complaint.ComplaintRepository;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.ComplaintForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ComplaintManagementImpl implements ComplaintManagement {

    private final ComplaintRepository complaintRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Page<Complaint> getCurrentUserComplaints(Pageable pageable) {
        return complaintRepository.findByAuthor(userService.getCurrentUser(), pageable);
    }

    @Override
    public void revoke(Complaint complaint) {

    }

    @Override
    public void create(User blamed, ComplaintForm form) {

    }

    @Override
    public void toModeration(Complaint complaint) {

    }
}
