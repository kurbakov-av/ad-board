package com.example.adboard.domain.ad;

import com.example.adboard.domain.Status;
import com.example.adboard.domain.image.Image;
import com.example.adboard.domain.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ads")
@Data
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 10, max = 65)
    @Column(nullable = false)
    private String title;

    @Length(min = 10, max = 5000)
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @ManyToOne(optional = false)
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<AdView> views;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private Collection<Image> images;

    @ManyToOne(optional = false)
    private User author;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
