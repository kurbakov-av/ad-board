package com.example.adboard.web.form;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AccountForm {

    @NotNull
    String firstName;

    String lastName;
}
