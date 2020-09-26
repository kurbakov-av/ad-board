package com.example.adboard.domain.user.ban;

import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_unban")
@Data
public class UserUnban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 1000)
    @Column(nullable = false, length = 1000)
    private String reason;

    private boolean schedule;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User targetUser;

    @Column(nullable = false)
    private LocalDateTime unblockingAt;
}
