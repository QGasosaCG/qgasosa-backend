package com.qgasosa.backend.security;

import com.qgasosa.backend.exception.ErrorResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration}")
    private Long EXPIRATION_DATE;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public boolean isTokenValid(String token) {
        if (token == null) return false;

        Claims claims = this.getClaims(token);
        boolean isValid = false;

        if (claims != null) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            isValid = username != null && expirationDate != null && now.before(expirationDate);
        }

        return isValid;
    }

    public String extractUsername(String token) {
        Claims claims = this.getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    public static ErrorResponse buildAuthError(String message, int statusCode, HttpServletResponse response) {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        return new ErrorResponse(message);
    }
}
