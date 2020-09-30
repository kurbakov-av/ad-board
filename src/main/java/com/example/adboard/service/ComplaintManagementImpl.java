package com.example.adboard.service;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.domain.complaint.ComplaintRepository;
import com.example.adboard.domain.user.User;
import com.example.adboard.util.ComplaintMapper;
import com.example.adboard.web.form.ComplaintForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ComplaintManagementImpl implements ComplaintManagement {

    private final ComplaintRepository complaintRepository;

    private final UserService userService;

    private final ComplaintMapper mapper;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Page<Complaint> getCurrentUserComplaints(Pageable pageable) {
        return complaintRepository.findByAuthor(userService.getCurrentUser(), pageable);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and #principal.username.equalsIgnoreCase(#complaint.author.username)")
    public void revoke(Complaint complaint) {
        Assert.state(complaint.getStatus().isModeration(), "Complaint not in moderation");

        complaint.setStatus(Status.CLOSE);
        complaintRepository.save(complaint);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER') and !(#principal.username.equalsIgnoreCase(#blamed.username))")
    public void create(User blamed, ComplaintForm form) {
        Complaint complaint = mapper.toComplaint(form);
        complaint.setAuthor(userService.getCurrentUser());
        complaint.setAddressedUser(blamed);
        complaintRepository.save(complaint);
    }

    @Override
    public void toModeration(Complaint complaint) {

    }
}
