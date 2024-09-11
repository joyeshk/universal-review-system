package com.jk.universalreview.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2ClientConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] whiteList = new String[]{"/actuator/*","/v3/api-docs/**","/swagger-ui/**","/users/signup"};
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(whiteList).permitAll()
                        .anyRequest().authenticated()
        ).oauth2Client(Customizer.withDefaults())
                .oauth2ResourceServer(spec->spec.jwt(Customizer.withDefaults()));
        
        //allow all URLS
        //http.authorizeRequests().anyRequest().permitAll();




        return http.build();
    }
}
