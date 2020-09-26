package com.example.adboard.domain.user.ban;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUnbanRepository extends JpaRepository<UserUnban, Long> {
}
