package com.example.adboard.service;

import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.ComplaintForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintManagementImpl implements ComplaintManagement {

    @Override
    public Page<Complaint> getCurrentUserComplaints(Pageable pageable) {
        return null;
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
