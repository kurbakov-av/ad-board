package com.example.adboard.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"phone"})
@Embeddable
public class ContactCard {

    private String firstName;

    private String lastName;

    @Pattern(regexp = "[\\d]{11}")
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone.replaceAll("[^\\d]+", "");
    }
}
