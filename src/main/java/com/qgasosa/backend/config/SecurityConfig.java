package com.qgasosa.backend.config;

import com.qgasosa.backend.config.security.AuthEntryPoint;
import com.qgasosa.backend.config.security.SecurityDSL;
import com.qgasosa.backend.security.JWTUtil;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    @Autowired
    private JWTUtil jwtUtil;

    @Bean
    public SecurityDSL securityDSL() {
        return new SecurityDSL(userDetailsService, handlerExceptionResolver, jwtUtil);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable();

        return http
                .formLogin()
                .loginProcessingUrl(Constants.API_BASE_URL + "/login")
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers(Constants.API_BASE_URL + "/admin/**").authenticated()
                        .anyRequest().permitAll())
                .apply(securityDSL())
                .and()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling()
                .authenticationEntryPoint(new AuthEntryPoint())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}
