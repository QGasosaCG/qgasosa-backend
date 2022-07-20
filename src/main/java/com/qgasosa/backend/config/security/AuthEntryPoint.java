package com.qgasosa.backend.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.qgasosa.backend.exception.ErrorResponse;
import com.qgasosa.backend.security.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class AuthEntryPoint implements AuthenticationEntryPoint {

    private static final String UNAUTHORIZED_MESSAGE = "User is not authenticated.";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ErrorResponse error = JWTUtil.buildAuthError(UNAUTHORIZED_MESSAGE, HttpStatus.UNAUTHORIZED.value(), response);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(new ObjectMapper().writeValueAsBytes(error));
        outputStream.flush();
        outputStream.close();
    }
}
