package com.example.adboard.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Activation {

    private boolean active;

    private String code;

    private LocalDateTime activationAt;

    private LocalDateTime expiredAt;
}
