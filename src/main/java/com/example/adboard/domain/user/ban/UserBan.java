package com.example.adboard.domain.user.ban;

import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_bans")
@Data
public class UserBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 10, max = 1000)
    @Column(nullable = false, length = 1000)
    private String reason;

    private boolean permanent;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User targetUser;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
        if (permanent) {
            endAt = LocalDateTime.MAX;
        }
    }
}
