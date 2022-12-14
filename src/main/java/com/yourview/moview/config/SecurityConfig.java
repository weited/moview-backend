package com.yourview.moview.config;

import com.yourview.moview.auth.AuthEntryPoint;
import com.yourview.moview.auth.MoviewUserDetailService;
import com.yourview.moview.jwt.JwtConfig;
import com.yourview.moview.jwt.JwtTokenVerifyFilter;
import com.yourview.moview.jwt.JwtUsernameAndPasswordAuthFilter;
import com.yourview.moview.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@Setter
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] AUTH_URL_WHITELIST = {
            "/",
            "/actuator",
            "/users/register",
            "/users/login",
    };

    private final MoviewUserDetailService moviewUserDetailService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    private final JwtTokenVerifyFilter jwtTokenVerifyFilter;
    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests(authorize ->
                        authorize.antMatchers(AUTH_URL_WHITELIST).permitAll()
                                .antMatchers(HttpMethod.GET).permitAll()
                                .anyRequest().authenticated())
                .addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager(), secretKey, jwtConfig, userService))
                .addFilterAfter(jwtTokenVerifyFilter, JwtUsernameAndPasswordAuthFilter.class)
                .exceptionHandling().authenticationEntryPoint(new AuthEntryPoint())
                .and().build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(moviewUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }
}
