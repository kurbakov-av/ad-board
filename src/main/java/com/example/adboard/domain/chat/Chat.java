package com.example.adboard.domain.chat;

import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "chats")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean blocked = false;

    @Size(min = 2, max = 2)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> members;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
