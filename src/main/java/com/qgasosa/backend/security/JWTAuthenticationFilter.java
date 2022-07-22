package com.qgasosa.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qgasosa.backend.controller.response.AuthenticationResponse;
import com.qgasosa.backend.dto.AdminDTO;
import com.qgasosa.backend.util.Constants;
import org.hibernate.result.Outputs;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.setFilterProcessesUrl(Constants.API_BASE_URL + "/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {
			AdminDTO credentials = new ObjectMapper().readValue(req.getInputStream(), AdminDTO.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
		String username = ((AdminPrincipal) auth.getPrincipal()).getUsername();
		logger.info(String.format("Admin '%s' successfully authenticated", username));

		String token = jwtUtil.generateToken(username);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse(username, token);

		OutputStream outputStream = res.getOutputStream();
		outputStream.write(new ObjectMapper().writeValueAsBytes(authenticationResponse));
		outputStream.flush();
		outputStream.close();
	}
}
