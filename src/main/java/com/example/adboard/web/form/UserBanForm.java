package com.example.adboard.web.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class UserBanForm {

    @NotNull
    private final String reason;

    @NotNull
    private final LocalDateTime startAt;

    private final LocalDateTime endAt;

    private final Boolean permanent;
}
