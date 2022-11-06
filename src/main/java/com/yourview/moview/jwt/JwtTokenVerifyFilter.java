package com.yourview.moview.jwt;

import com.yourview.moview.auth.MoviewAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenVerifyFilter extends OncePerRequestFilter {

    private static final String BEARER = "Bearer ";
    private static final String AUTHORITY = "authority";
    private static final String AUTHORITIES = "authorities";

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(jwtConfig.getAuthorization());

        if (authHeader == null || !authHeader.startsWith(BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.replace(BEARER, "");

        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String username = body.getSubject();
        long userId = (Integer) body.get("userId");
        List<Map<String, String>> authorities = (List<Map<String, String>>) body.get(AUTHORITIES);

        Set<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
                .map(map -> new SimpleGrantedAuthority(map.get(AUTHORITY)))
                .collect(Collectors.toSet());

        Authentication authentication = new MoviewAuthenticationToken(
                userId,
               username,
                null,
                grantedAuthorities
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
