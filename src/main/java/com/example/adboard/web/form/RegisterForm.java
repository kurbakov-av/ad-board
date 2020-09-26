package com.example.adboard.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class RegisterForm {

    @Length(min = 2)
    private final String username;

    @Email(regexp = ".+@.+")
    private final String email;

    @Length(min = 8, max = 65)
    private final String password;
}
