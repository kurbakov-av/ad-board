package com.example.adboard.domain.chat;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 1, max = 1000)
    @Column(nullable = false, length = 1000)
    private String text;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @ManyToOne(optional = false)
    private Chat chat;

    private boolean read = false;

    private LocalDateTime readAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public enum Status {
        CREATED, PENDING, BLOCK, DELIVERY;
    }
}
