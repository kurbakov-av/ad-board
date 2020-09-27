package com.example.adboard.domain.ad;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findAllByStatus(Status status, Pageable pageable);

    Page<Ad> findAllByStatusAndAuthor(Status status, User author, Pageable pageable);

    Page<Ad> findAllByAuthor(User author, Pageable pageable);

    Optional<Ad> findByIdAndAuthor(Long id, User author);

    Optional<Ad> findByIdAndStatus(Long id, Status status);
}
