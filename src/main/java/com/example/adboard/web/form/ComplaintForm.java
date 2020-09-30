package com.example.adboard.web.form;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Value
public class ComplaintForm {

    @Length(min = 10, max = 1000)
    String reason;

    @Min(1)
    Long blameId;
}
