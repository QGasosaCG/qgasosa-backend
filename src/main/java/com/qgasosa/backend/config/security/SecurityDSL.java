package com.qgasosa.backend.config.security;

import com.qgasosa.backend.security.JWTAuthenticationFilter;
import com.qgasosa.backend.security.JWTAuthorizationFilter;
import com.qgasosa.backend.security.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

public class SecurityDSL extends AbstractHttpConfigurer<SecurityDSL, HttpSecurity> {

    private UserDetailsService userDetailsService;
    private HandlerExceptionResolver handlerExceptionResolver;
    private JWTUtil jwtUtil;

    public SecurityDSL(UserDetailsService userDetailsService, HandlerExceptionResolver handlerExceptionResolver, JWTUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.handlerExceptionResolver = handlerExceptionResolver;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void configure(HttpSecurity http) {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.addFilter(new JWTAuthenticationFilter(authenticationManager, jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager, userDetailsService, handlerExceptionResolver, jwtUtil));
    }
}
