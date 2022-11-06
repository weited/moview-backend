package com.yourview.moview.jwt;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
