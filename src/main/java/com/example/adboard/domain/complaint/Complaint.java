package com.example.adboard.domain.complaint;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 10, max = 1000)
    @Column(nullable = false, length = 1000)
    private String reason;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User addressedUser;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
