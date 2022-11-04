package com.yourview.moview.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPutDto {
    @NotBlank
    @Size(max = 128, message = "Name can not be more than 128 characters.")
    private String username;

    @Size(max = 128, message = "Name can not be more than 128 characters.")
    private String firstName;

    @Size(max = 128, message = "Name can not be more than 128 characters.")
    private String lastName;

    @NotBlank(message = "Email must not be blank.")
    @Size(max = 128, message = "Email name can not be more than 128 characters.")
    @Email(message = "Email should be a valid email.")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = "^(?=\\S*[a-zA-Z])(?=\\S*[0-9#!\"$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{8,}$",
            message = "Your password must be at least 8 character long and contains at least one non-letter character.")
    private String password;

    @Pattern(regexp = "/^(?:([A-Za-z]+):)?(\\/{0,3})([0-9.\\-A-Za-z]+)(?::(\\d+))?(?:\\/([^?#]*))?(?:\\?([^#]*))?(?:#(.*))?$/",
            message = "Your profile image url should be valid")
    private String profileImgUrl;
}