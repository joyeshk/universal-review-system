package com.jk.universalreview.reviews.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] whiteList = new String[]{"/actuator/*","/v3/api-docs/**","/swagger-ui/**"};
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(whiteList).permitAll()
                .anyRequest().authenticated()
        ).oauth2ResourceServer(spec->spec.jwt(Customizer.withDefaults()));

        //allow all URLS
        //http.authorizeRequests().anyRequest().permitAll();
        return http.build();
    }
}
