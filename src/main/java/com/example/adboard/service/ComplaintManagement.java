package com.example.adboard.service;

import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.domain.user.User;
import com.example.adboard.web.form.ComplaintForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComplaintManagement {

    Page<Complaint> getCurrentUserComplaints(Pageable pageable);

    void revoke(Complaint complaint);

    void create(User blamed, ComplaintForm form);

    void toModeration(Complaint complaint);
}
