package com.example.adboard.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AdForm {

    @Length(min = 10, max = 65)
    private final String title;

    @Length(min = 10, max = 5000)
    private final String description;

    @NotNull
    private final String address;

    @NotNull
    private final BigDecimal price;

    @Min(1)
    @NotNull
    private final Long categoryId;
}
