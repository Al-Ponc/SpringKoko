package com.koko.kokospringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Metodo para encriptacion de password
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests -> requests
                        .requestMatchers("/", "/").permitAll()
                        .requestMatchers("/categorias**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()))
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/hello"))
                .logout(logout -> logout
                        .permitAll());

        return http.build();
    }
}
