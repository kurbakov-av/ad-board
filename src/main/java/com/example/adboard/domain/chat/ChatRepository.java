package com.example.adboard.domain.chat;

import com.example.adboard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findByIdAndMembersContains(Long id, User member);

    Optional<Chat> findByMembersContainsAndMembersContains(User member1, User member2);

    boolean existsByMembersContains(User member);

    boolean existsByIdAndMembersContains(Long id, User member);
}
