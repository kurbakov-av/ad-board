package com.example.adboard.domain.user;

import com.example.adboard.domain.image.Image;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Email(regexp = ".+@.+")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Password password = new Password();

    @Embedded
    private Activation activation = new Activation();

    private boolean blocked = false;

    private boolean markRemoved = false;

    @OneToOne
    private Image avatar;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<GrantedAuthority> authorities = new HashSet<>();

    @Embedded
    private ContactCard contactCard;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
