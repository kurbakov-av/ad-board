package com.example.adboard.domain.feedback;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.ad.Ad;
import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 10, max = 1000)
    @Column(nullable = false, length = 1000)
    private String text;

    @Size(min = 1, max = 5)
    private int rating;

    @ManyToOne(optional = false)
    private Ad ad;

    @ManyToOne(optional = false)
    private User author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
