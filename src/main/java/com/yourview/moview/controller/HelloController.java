package com.yourview.moview.controller;

import com.yourview.moview.auth.MoviewAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// only for test, will be removed later

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String index(Authentication authentication) {
        MoviewAuthenticationToken authDetails = (MoviewAuthenticationToken) authentication;

        if (authDetails !=  null) {
            return "Hello, "+ authDetails.getName() + ". This is moview api. You id is: " + authDetails.getUserId();
        }

        return "Hello, This is moview api. Please login";
    }
}
