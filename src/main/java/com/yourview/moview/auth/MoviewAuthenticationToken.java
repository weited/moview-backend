package com.yourview.moview.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

@Setter
@Getter
public class MoviewAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final Long userId;

    public MoviewAuthenticationToken(Long userId, Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    @Override
    public Map<String, Long> getDetails() {
        return Map.of("UserId", userId);
    }

}
