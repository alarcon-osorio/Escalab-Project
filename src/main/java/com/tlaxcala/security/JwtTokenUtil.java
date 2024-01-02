package com.tlaxcala.security;

import java.io.Serializable;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component // generic stereotype 
public class JwtTokenUtil implements Serializable {

    // mil.
    public final long JWT_TOKEN_VALIDATY = 5 * 60 * 60 * 1000; // 5 hours

    @Value("{jwt.secret}") // EL = Expression Language
    private String secret;

    public String generateToken(UserDetails userDetails) {
        // definir que le quiers agregar al token
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));
        claims.put("test", "txalcala-test-value");

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder() // para comenzar a construirlo
            .setClaims(claims) // info
            .setSubject(subject) // user
            .setIssuedAt(new Date(System.currentTimeMillis())) // fecha de creación
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDATY)) // fecha de expiración
            .signWith(getSigninKey()) // la llave secreta
            .compact(); // devolver el token con las especificaciones con las cuales se creo
    }

    private Key getSigninKey() { // creamos la llave secreta
        return new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS512.getJcaName()); // la especificación de la llave o firma de tokens
    }

    // utils
    public Claims getAllClaimsFromToken(String token) { // recopila el body/payload del token
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    // obtiene las credentials/claims en base al token
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token) { // obtenemos el usuario en base al token
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) { // devuelve la fecha de expiración
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) { // saber si el token expiró o no
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) { // para validar si el token pertenece a ese usuario y si está vigente en la sesión
        final String username = getUsernameFromToken(token);
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
}
