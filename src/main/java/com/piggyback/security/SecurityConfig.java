package com.piggyback.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ modern lambda-style syntax
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/accounts").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // ✅ enables HTTP Basic Auth without deprecated methods

        return http.build();
    }

}
