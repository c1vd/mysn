package com.company.mysn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.company.mysn.services.MyUserDetailsService;


@Configuration
public class SecurityConfig {
    @Bean
    UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin").denyAll()
                .anyRequest().permitAll()   // Allow all requests without authentication
            );

        return http.build();
    }
}