package com.example.adboard.domain.complaint;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    Page<Complaint> findByStatusAndAuthor(Status status, User author, Pageable pageable);

    Page<Complaint> findByAuthor(User author, Pageable pageable);
}
