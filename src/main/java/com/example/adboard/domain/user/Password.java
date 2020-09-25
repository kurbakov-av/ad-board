package com.example.adboard.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(exclude = {"value"})
public class Password {

    @Length(min = 8)
    @Column(nullable = false, length = 1000)
    private String value;

    @Embedded
    @AttributeOverride(name = "expiredAt", column = @Column(name = "resetCodeExpeiredAt"))
    private Reset reset = new Reset();

    @Getter
    @Setter
    @Embeddable
    public static class Reset {

        private String resetCode;

        private LocalDateTime expiredAt;
    }
}
