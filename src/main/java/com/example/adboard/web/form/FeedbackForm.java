package com.example.adboard.web.form;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;

@Value
public class FeedbackForm {

    @Length(min = 10, max = 1000)
    String text;

    @Size(min = 1, max = 5)
    int rating;
}
