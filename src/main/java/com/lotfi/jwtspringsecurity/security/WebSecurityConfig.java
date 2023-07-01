package com.lotfi.jwtspringsecurity.security;

import com.lotfi.jwtspringsecurity.security.jwt.AuthEntryPointJwt;
import com.lotfi.jwtspringsecurity.security.jwt.AuthTokenFilter;
import com.lotfi.jwtspringsecurity.security.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
@RequiredArgsConstructor
public class WebSecurityConfig {

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt authEntryPoint;

  @Autowired
  private AuthTokenFilter authHeaderFilter;

  @Bean
  public static PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
            authorize -> authorize
                    .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/api/test/**").permitAll()
                    .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(exception -> exception
            .authenticationEntryPoint(authEntryPoint))
            .addFilterBefore(authHeaderFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }
}
