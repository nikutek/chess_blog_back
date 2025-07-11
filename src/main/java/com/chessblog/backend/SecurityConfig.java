package com.chessblog.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/h2-console/**", "/games/create").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**", "/games/create")
            )
            .headers(headers -> headers.frameOptions().disable());
        return http.build();
    }
}